package com.ottawa.library.libraryms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ottawa.library.libraryms.models.Book;

@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	  	@Override
	    @Query("SELECT b FROM Book b")
	    List<Book> findAll();
	  	
	    @Query("SELECT b FROM Book b WHERE b.isFeatured='T'")
	    List<Book> findFeatured();

	    @Query("SELECT b FROM Book b WHERE b.bookName like  %:bookName% or b.isbn like %:bookName%  or b.description like %:bookName% ")
	     List<Book> search(@Param("bookName")String bookName);

	}
