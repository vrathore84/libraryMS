package com.ottawa.library.libraryms.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ottawa.library.libraryms.services.BookService;

@Controller
public class MainController {

	@Autowired
	private  BookService  bookService;
	
	
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(Model books){
        books.addAttribute("books", bookService.findFeatured());
    	return "home";
    }
    
    @RequestMapping(value="/signin",method = RequestMethod.GET)
    public String loginpage(){
    	return "login";
    }

    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
}