package com.ottawa.library.libraryms.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "issues")
public class Issue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="issue_id")
    private Long issueId;
	
	@OneToOne
 	@JoinColumn(name="copy_id")
 	private Copy copy;
	
	@OneToOne
 	@JoinColumn(name="user_id")
 	private User user;

	@Column(name="issue_date")
	private Timestamp issueDate;

	@Column(name="return_date")
	private Timestamp returnDate;

	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Timestamp issueDate) {
		this.issueDate = issueDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
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
