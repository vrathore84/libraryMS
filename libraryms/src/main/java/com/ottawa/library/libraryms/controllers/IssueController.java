package com.ottawa.library.libraryms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ottawa.library.libraryms.models.Issue;
import com.ottawa.library.libraryms.services.IssueService;

@Controller
public class IssueController {
	

@Autowired
private IssueService issueService;

@RequestMapping(value="/admin/lost/copies",method = RequestMethod.GET)
public String lostBooks(Model issues){
	issues.addAttribute("issues",issueService.getLostIssues());
	return "lostCopies";
}

@RequestMapping(value="/admin/issue/books",method = RequestMethod.POST)
public String issueBook(Model issues, Issue issue){
	return "issue";
}

@RequestMapping(value="/admin/issue",method = RequestMethod.GET)
public String issuedBooks(Model issues){
	issues.addAttribute("issues",issueService.getAllIssues());
	return "issue";
}

}
