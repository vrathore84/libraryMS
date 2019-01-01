package com.ottawa.library.libraryms.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sections")
public class Section {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="section_id")
    private Long sectionId;
	
	@Column(name="section_name")
	private String sectionName;
	
	@Column(name="section_description")
	private String sectionDescription;
	
	
	@Column(name="shelf_count")
	private int shelfCount;
	
    @OneToMany(mappedBy="section", fetch=FetchType.EAGER)
    private Set<Shelf> shelfs;
	
	@Column(name="is_deleted")
	private String isDeleted;	
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionDescription() {
		return sectionDescription;
	}

	public void setSectionDescription(String sectionDescription) {
		this.sectionDescription = sectionDescription;
	}

	public int getShelfCount() {
		return shelfCount;
	}

	public void setShelfCount(int shelfCount) {
		this.shelfCount = shelfCount;
	}
	
	public Set<Shelf> getShelfs() {
		return shelfs;
	}

	public void setShelfs(Set<Shelf> shelfs) {
		this.shelfs = shelfs;
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

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
}
