package com.ottawa.library.libraryms.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ottawa.library.libraryms.models.Book;
import com.ottawa.library.libraryms.services.BookService;
import com.ottawa.library.libraryms.services.SectionService;

@Controller
public class BookController {
	
@Autowired
private SectionService sectionService;

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

}
