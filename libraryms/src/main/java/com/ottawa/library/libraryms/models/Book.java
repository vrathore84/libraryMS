package com.ottawa.library.libraryms.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="book_id")
    private Long bookId;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="book_name")
	private String bookName;
	
	@Column(name="description")
	private String description;

	 @OneToMany(mappedBy="book", fetch=FetchType.EAGER)
	 private Set<Copy> copies;

	@Column(name="is_deleted")
	private String isDeleted;
	
	@Column(name="is_featured")
	private String isFeatured;	
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@Transient
	private Long sectionId;
	@Transient
	private Long shelfId;
	@Transient
	private Long layerId;
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public Set<Copy> getCopies() {
		return copies;
	}

	public void setCopies(Set<Copy> copies) {
		this.copies = copies;
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

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Long getShelfId() {
		return shelfId;
	}

	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}

	public Long getLayerId() {
		return layerId;
	}

	public void setLayerId(Long layerId) {
		this.layerId = layerId;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(String isFeatured) {
		this.isFeatured = isFeatured;
	}
	
}
