package com.ottawa.library.libraryms.services;

import java.text.ParseException;
import java.util.List;

import com.ottawa.library.libraryms.models.Issue;

public interface IssueService {
	
	public List<Issue> getAllIssues();
	public List<Issue> getLostIssues();
	public void addIssue(Long copyIdIssue,Long userId, String issuedate, String returndate) throws ParseException;
	public Issue findOne(Long issueId);
	public void editIssue(Issue issue);
	public void returnBook(Long copyId);


}
