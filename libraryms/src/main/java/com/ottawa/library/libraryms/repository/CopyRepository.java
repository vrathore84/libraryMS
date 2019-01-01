package com.ottawa.library.libraryms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ottawa.library.libraryms.models.Copy;

@Transactional
@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {
	
	  	@Override
	    @Query("SELECT c FROM Copy c WHERE c.isDamaged='F'")
	    List<Copy> findAll();

	}
