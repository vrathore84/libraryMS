package com.ottawa.library.libraryms.services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottawa.library.libraryms.models.Copy;
import com.ottawa.library.libraryms.models.Issue;
import com.ottawa.library.libraryms.models.Slot;
import com.ottawa.library.libraryms.models.User;
import com.ottawa.library.libraryms.repository.CopyRepository;
import com.ottawa.library.libraryms.repository.IssueRepository;
import com.ottawa.library.libraryms.repository.SlotRepository;
import com.ottawa.library.libraryms.repository.UserRepository;



@Service
public class IssueServiceImpl implements IssueService{

	@Autowired
	private IssueRepository issueRepository;
	@Autowired
	private CopyRepository copyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SlotRepository slotRepository;


	@Override
	public List<Issue> getAllIssues() {
		Timestamp sixMonthBack = new Timestamp(System.currentTimeMillis()-(1000L*60*60*24*30*6));
		return issueRepository.findAllIssuesSixBack(sixMonthBack);
	}

	@Override
	public List<Issue> getLostIssues() {
		Timestamp sixMonthBack = new Timestamp(System.currentTimeMillis()-(1000L*60*60*24*30*6));
		return issueRepository.findLostBooks(sixMonthBack);
	}

	@Override
	public void addIssue(Long copyIdIssue, Long userId, String issuedate, String returndate) throws ParseException {
		Date issueDate =new SimpleDateFormat("MM/dd/yyyy").parse(issuedate);
		Date returnDate =new SimpleDateFormat("MM/dd/yyyy").parse(returndate);
		Copy copy = copyRepository.findById(copyIdIssue).get();
		User user = userRepository.findById(userId).get();
		Issue issue = new Issue();
		issue.setIsReturned("F");
		issue.setCopy(copy);
		issue.setUser(user);
		issue.setIssueDate(new Timestamp(issueDate.getTime()));
		issue.setReturnDate(new Timestamp(returnDate.getTime()));
		issue.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		issue.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		Issue createdIssue = issueRepository.save(issue);
		Slot slot = createdIssue.getCopy().getSlot();
		slot.setIsOccupied("F");
		slotRepository.save(slot);		
	}

	@Override
	public Issue findOne(Long issueId) {
		return issueRepository.findById(issueId).get();
	}

	@Override
	public void editIssue(Issue issue) {
		 issueRepository.save(issue);
	}

	@Override
	public void returnBook(Long copyId) {
		Copy copy = copyRepository.findById(copyId).get();
		List<Issue> issues = issueRepository.findByCopy(copy);
		Issue issue = null;
		for(int i=0;i<=issues.size()-1;i++){
			if(issues.get(i).getIsReturned().equals("F")){
				issue = (Issue)issues.get(i);
				break;
			}
		}
		issue.setIsReturned("T");
		issueRepository.save(issue);
		Slot slot = copy.getSlot();
		slot.setIsOccupied("T");
		slotRepository.save(slot);
	}

}
