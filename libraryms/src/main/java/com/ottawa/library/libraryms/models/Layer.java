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

@Entity
@Table(name = "layers")
public class Layer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="layer_id")
    private Long layerId;
	
	@Column(name="layer_name")
	private String layerName;
	
 	@ManyToOne
    @JoinColumn(name="shelf_id", nullable=false)
    private Shelf shelf;
 	
	 @OneToMany(mappedBy="layer", fetch=FetchType.EAGER)
	 private Set<Slot> slots;
 	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Long getLayerId() {
		return layerId;
	}

	public void setLayerId(Long layerId) {
		this.layerId = layerId;
	}

	public String getLayerName() {
		return layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public Shelf getShelf() {
		return shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	public void setSlots(Set<Slot> slots) {
		this.slots = slots;
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