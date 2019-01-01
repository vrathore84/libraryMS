package com.ottawa.library.libraryms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ottawa.library.libraryms.models.Shelf;

@Transactional
@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
	
}
