package com.ottawa.library.libraryms;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ottawa.library.libraryms.controllers.BookController;
import com.ottawa.library.libraryms.models.Book;
import com.ottawa.library.libraryms.repository.BookRepository;
import com.ottawa.library.libraryms.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibrarymsApplicationTests {
	
	@Resource
    private BookController bookController;

	
	@Autowired
	private BookService bookService;
	
	@Test
	public void contextLoads() {
	    //  String message = this.restTemplate.getForObject("/admin/book/details", String.class);
	      //assertEquals("", message);
	}
	
	
	 @Test
	   public void testBook() {
	    //  String message = this.restTemplate.getForObject("/admin/book/details", String.class);
	     // assertEquals("", message);
	   }
	 
	 @Test
	 public void testBookService(){
		 Book book = new Book();
		 assertEquals("100006", bookService.findOne(16L).getIsbn());
	 }
}

