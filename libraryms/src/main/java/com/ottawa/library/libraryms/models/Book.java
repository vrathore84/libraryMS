package com.ottawa.library.libraryms.models;

import java.sql.Timestamp;

import javax.persistence.*;


@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name="book_id")
    private int bookId;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="section_id")
	private int sectionId;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
