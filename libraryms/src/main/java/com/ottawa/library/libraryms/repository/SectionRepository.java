package com.ottawa.library.libraryms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ottawa.library.libraryms.models.Section;

@Transactional
@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
	
  	@Override
    @Query("SELECT s FROM Section s WHERE s.isDeleted='F'")
    List<Section> findAll();
	}
