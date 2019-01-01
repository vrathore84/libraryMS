package com.ottawa.library.libraryms.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "slots")
public class Slot {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="slot_id")
    private Long slotId;
	
	@Column(name="slot_name")
	private String slotName;
	
 	@ManyToOne
    @JoinColumn(name="layer_id", nullable=false)
    private Layer layer;
 	
	@Column(name="copy_id")
    private Long copyId;
	
	@Column(name="is_occupied")
    private String isOccupied;
 	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public Layer getLayer() {
		return layer;
	}

	public void setLayer(Layer layer) {
		this.layer = layer;
	}
	
	public Long getCopyId() {
		return copyId;
	}

	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}

	public String getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(String isOccupied) {
		this.isOccupied = isOccupied;
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