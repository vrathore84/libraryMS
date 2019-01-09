package com.ottawa.library.libraryms.models;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shelfs")
public class Shelf {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="shelf_id")
    private Long shelfId;
	
	@Column(name="shelf_name")
	private String shelfName;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="section_id", nullable=false)
    private Section section;
 	
 	@JsonIgnore
	@OneToMany(mappedBy="shelf",fetch=FetchType.EAGER)
 	 private Set<Layer> layers;
 		
 	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	

	public Long getShelfId() {
		return shelfId;
	}

	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}

	public String getShelfName() {
		return shelfName;
	}

	public void setShelfName(String shelfName) {
		this.shelfName = shelfName;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public Set<Layer> getLayers() {
		return layers;
	}

	public void setLayers(Set<Layer> layers) {
		this.layers = layers;
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
