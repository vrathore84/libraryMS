package com.ottawa.library.libraryms.controllers;

import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ottawa.library.libraryms.models.Book;
import com.ottawa.library.libraryms.models.Copy;
import com.ottawa.library.libraryms.services.BookService;
import com.ottawa.library.libraryms.services.IssueService;
import com.ottawa.library.libraryms.services.SectionService;
import com.ottawa.library.libraryms.services.UserService;

@Controller
public class BookController {
	
@Autowired
private SectionService sectionService;
@Autowired
private UserService userService;
@Autowired
private IssueService issueService;

@Autowired
private BookService bookService;
private static Logger logger = LoggerFactory.getLogger(BookController.class);


@RequestMapping(value="/admin/books",method = RequestMethod.GET)
public String sectionpage(Model sections){
	sections.addAttribute("sections", sectionService.getAllSections() );
	sections.addAttribute("books",bookService.getAllBooks());
	return "book";
}

@RequestMapping(value="/admin/addBook",method = RequestMethod.POST)
public String addBook(Model sections, Book book){
	bookService.addBook(book);
	sections.addAttribute("sections", sectionService.getAllSections() );
	sections.addAttribute("books",bookService.getAllBooks());
	return "book";
}

@RequestMapping(value="/admin/searchBooks",method = RequestMethod.GET)
public String  searchBook(Model sections, String bookName){
	logger.info("Search String "+bookName);
	sections.addAttribute("sections", sectionService.getAllSections() );
	sections.addAttribute("books",bookService.search(bookName));
	return "book";
}

@RequestMapping(value="/admin/book/details",method = RequestMethod.GET)
public @ResponseBody Book   getShelfLayers(Long bookId ,Model book){
	Book bookEntity = bookService.findOne(bookId); 
	 return bookEntity;
}


@RequestMapping(value="/admin/getBook",method = RequestMethod.GET)
public @ResponseBody HashMap<String, Object>  getBook(Long bookId , Long copyId,Model book){
	Book bookEntity = bookService.findOne(bookId);
	
	HashMap<String, Object> bookIssue = new HashMap<>();
	Iterator<Copy> iterator =  bookEntity.getCopies().iterator();
	Copy copy = null;
    while (iterator.hasNext()) {
       Copy copyNew = iterator.next();
        if (copyNew.getCopyId().equals(copyId)) {
             copy = copyNew ;
        }
    }
	bookIssue.put("copy", copy);
	bookEntity.setCopies(new HashSet<Copy>());
	bookIssue.put("book", bookEntity);
	bookIssue.put("users", userService.getAllUsers());
	return bookIssue;
}

@RequestMapping(value="/admin/return/books",method = RequestMethod.POST)
public String returnBook(Model sections, Long  returnCopyId) throws ParseException{
	issueService.returnBook(returnCopyId);
	sections.addAttribute("sections", sectionService.getAllSections() );
	sections.addAttribute("books",bookService.getAllBooks());
	return "book";
}


}
