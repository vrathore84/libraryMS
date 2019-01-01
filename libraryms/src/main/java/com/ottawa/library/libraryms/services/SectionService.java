package com.ottawa.library.libraryms.services;

import java.util.List;
import java.util.Set;

import com.ottawa.library.libraryms.models.Layer;
import com.ottawa.library.libraryms.models.Section;
import com.ottawa.library.libraryms.models.Shelf;

public interface SectionService {
	
	public List<Section> getAllSections();
	public void addSection(Section section);
	public Set<Shelf> getShelfBySection(Long sectionId);
	public Set<Layer> getLayerByShelf(Long shelfId);

}
