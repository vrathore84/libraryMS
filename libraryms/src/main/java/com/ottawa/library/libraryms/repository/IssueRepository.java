package com.ottawa.library.libraryms.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ottawa.library.libraryms.models.Issue;

@Transactional
@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
	
	    @Query("SELECT i FROM Issue i WHERE i.issueDate > :sixMonthBack ")
	    List<Issue> findAllIssuesSixBack(@Param("sixMonthBack") Timestamp sixMonthBack);
	  	
	    @Query("SELECT i FROM Issue i WHERE i.issueDate < :sixMonthBack ")
	    List<Issue> findLostBooks(@Param("sixMonthBack") Timestamp sixMonthBack);

	}
