package com.ottawa.library.libraryms.models;

import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "copies")
public class Copy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="copy_id")
    private Long copyId;
	
	@JsonIgnore
 	@ManyToOne
    @JoinColumn(name="book_id", nullable=false)
	private Book book;
 	
	
 	@OneToOne
 	@JoinColumn(name="slot_id")
 	private Slot slot;
 	
 	@Column(name="layer_id")
 	private Long layerId;
 	
 	@OneToOne
 	@JoinColumn(name="shelf_id")
 	private Shelf shelf;

 	@Column(name="section_id")
 	private Long sectionId;
	
	@Column(name="is_damaged")
	private String isDamaged;
		
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Long getCopyId() {
		return copyId;
	}

	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public String getIsDamaged() {
		return isDamaged;
	}

	public void setIsDamaged(String isDamaged) {
		this.isDamaged = isDamaged;
	}

	public Long getLayerId() {
		return layerId;
	}

	public void setLayerId(Long layerId) {
		this.layerId = layerId;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
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
