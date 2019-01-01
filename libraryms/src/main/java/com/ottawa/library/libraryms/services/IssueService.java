package com.ottawa.library.libraryms.services;

import java.util.List;

import com.ottawa.library.libraryms.models.Issue;

public interface IssueService {
	
	public List<Issue> getAllIssues();
	public List<Issue> getLostIssues();


}
