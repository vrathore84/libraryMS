package com.ottawa.library.libraryms.controllers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ottawa.library.libraryms.models.Issue;
import com.ottawa.library.libraryms.services.IssueService;
import com.ottawa.library.libraryms.services.UserService;

@Controller
public class IssueController {
	

@Autowired
private IssueService issueService;

@Autowired
private UserService userService;

@RequestMapping(value="/admin/lost/copies",method = RequestMethod.GET)
public String lostBooks(Model issues){
	issues.addAttribute("issues",issueService.getLostIssues());
	return "lostCopies";
}

@RequestMapping(value="/admin/issue/books",method = RequestMethod.POST)
public String issueBook(Model issues, Long  copyIdIssue, Long userId, String issueDateV, String returnDateV) throws ParseException{
	issueService.addIssue(copyIdIssue,userId, issueDateV, returnDateV);
	issues.addAttribute("issues",issueService.getAllIssues());
	return "issue";
}

@RequestMapping(value="/admin/issue",method = RequestMethod.GET)
public String issuedBooks(Model issues){
	issues.addAttribute("issues",issueService.getAllIssues());
	return "issue";
}

@RequestMapping(value="/admin/issue/details",method = RequestMethod.GET)
public @ResponseBody HashMap<String, Object> getIssue(Long issueId ){
	HashMap<String, Object> issuemap = new HashMap<>();
	issuemap.put("issue", issueService.findOne(issueId));
	issuemap.put("users", userService.getAllUsers());
	 return issuemap;
}

@RequestMapping(value="/admin/editIssue/books",method = RequestMethod.POST)
public String editIssueBook(Model issues, Long issueId, Long  copyIdIssue, Long userId, String issueDateV, String returnDateV) throws ParseException{
	Date issueDate =new SimpleDateFormat("MM/dd/yyyy").parse(issueDateV);
	Date returnDate =new SimpleDateFormat("MM/dd/yyyy").parse(returnDateV);

	Issue issue = issueService.findOne(issueId);
	issue.setIssueDate(new Timestamp(issueDate.getTime()));
	issue.setReturnDate(new Timestamp(returnDate.getTime()));
	issueService.editIssue(issue);
	issues.addAttribute("issues",issueService.getAllIssues());
	return "issue";
}



}
