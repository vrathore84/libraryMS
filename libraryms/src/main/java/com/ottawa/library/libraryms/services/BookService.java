package com.ottawa.library.libraryms.services;

import java.util.List;

import com.ottawa.library.libraryms.models.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	public void addBook(Book book);
	public List<Book> findFeatured();
	public List<Book> search(String bookName);
	public Book findOne(Long bookId);

}
