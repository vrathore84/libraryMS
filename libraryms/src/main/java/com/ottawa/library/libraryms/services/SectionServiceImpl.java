package com.ottawa.library.libraryms.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottawa.library.libraryms.models.Layer;
import com.ottawa.library.libraryms.models.Section;
import com.ottawa.library.libraryms.models.Shelf;
import com.ottawa.library.libraryms.repository.LayerRepository;
import com.ottawa.library.libraryms.repository.SectionRepository;
import com.ottawa.library.libraryms.repository.ShelfRepository;


@Service
public class SectionServiceImpl implements SectionService{
	
@Autowired
private SectionRepository sectionRepository;
@Autowired
private ShelfRepository shelfRepository;
@Autowired
private LayerRepository layerRepository;

	@Override
	public List<Section> getAllSections() {
		return sectionRepository.findAll();
	}

	@Override
	public void addSection(Section section) {
		section.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		section.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		section.setIsDeleted("F");
		Section createdSection  = sectionRepository.save(section);
		int shelfCount = createdSection.getShelfCount();
		// create all shelfs based on shelf count
		for(int s=1;s<= shelfCount; s++)
		{
			Shelf newShelf = new Shelf();
			newShelf.setShelfName(section.getSectionId()+"SL"+s);
			newShelf.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			newShelf.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			newShelf.setSection(createdSection);
			Shelf createdShelf = shelfRepository.save(newShelf);
			// create 6 layers for each shelf
			for(int l=1; l<=6;l++){
				Layer newLayer = new Layer();
				newLayer.setLayerName(createdShelf.getShelfName()+"LY"+l);
				newLayer.setShelf(createdShelf);
				newLayer.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				newLayer.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				layerRepository.save(newLayer);
				// create 5 slots for each Layer
//				for(int ss=1;ss<=5;ss++){
//					Slot newSlot = new Slot();
//					newSlot.setSlotName(createdLayer.getLayerName()+"-SS-"+ss);
//					newSlot.setLayer(createdLayer);
//					newSlot.setIsOccupied("F");
//					newSlot.setCreatedAt(new Timestamp(System.currentTimeMillis()));
//					newSlot.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
//					slotRepository.save(newSlot);
//				}
			}
		}
		
		 		
	}

	@Override
	public Set<Shelf> getShelfBySection(Long sectionId) {
		Section section = sectionRepository.findById(sectionId).get();
		return section.getShelfs();
	}

	@Override
	public Set<Layer> getLayerByShelf(Long shelfId) {
		Shelf shelf = shelfRepository.findById(shelfId).get();
		return shelf.getLayers();
	}

}
