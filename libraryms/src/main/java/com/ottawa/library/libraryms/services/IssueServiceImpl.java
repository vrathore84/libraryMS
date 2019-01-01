package com.ottawa.library.libraryms.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottawa.library.libraryms.models.Issue;
import com.ottawa.library.libraryms.repository.IssueRepository;



@Service
public class IssueServiceImpl implements IssueService{

	@Autowired
	private IssueRepository issueRepository;

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

}
