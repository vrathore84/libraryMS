package com.ottawa.library.libraryms.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottawa.library.libraryms.models.Book;
import com.ottawa.library.libraryms.models.Copy;
import com.ottawa.library.libraryms.models.Layer;
import com.ottawa.library.libraryms.models.Shelf;
import com.ottawa.library.libraryms.models.Slot;
import com.ottawa.library.libraryms.repository.BookRepository;
import com.ottawa.library.libraryms.repository.CopyRepository;
import com.ottawa.library.libraryms.repository.LayerRepository;
import com.ottawa.library.libraryms.repository.ShelfRepository;
import com.ottawa.library.libraryms.repository.SlotRepository;



@Service
public class BookServiceImpl implements BookService{
	
@Autowired
private BookRepository bookRepository;
@Autowired
private SlotRepository slotRepository;
@Autowired
private LayerRepository layerRepository;
@Autowired
private ShelfRepository shelfRepository;
@Autowired
private CopyRepository copyRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void addBook(Book book) {
		book.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		book.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		book.setIsDeleted("F");
		book.setIsFeatured("F");
		Book createdBook = bookRepository.save(book);
		Layer layer = layerRepository.findById(book.getLayerId()).get();
		Shelf shelf = shelfRepository.findById(book.getShelfId()).get();
		
		//Set<Slot> slots = layer.getSlots(); 
		//Create 5 copies by default
		for(int c=1; c<=5;c++){
			Slot newSlot = new Slot();
			newSlot.setSlotName(layer.getLayerName()+"SS"+c);
			newSlot.setLayer(layer);
			newSlot.setIsOccupied("T");
			newSlot.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			newSlot.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			Slot createdSlot = slotRepository.save(newSlot);
			Copy copy = new Copy();
			copy.setBook(createdBook);
			copy.setCreatedAt(new Timestamp(System.currentTimeMillis()));
			copy.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
			copy.setIsDamaged("F");
			copy.setSlot(createdSlot);
			copy.setShelf(shelf);
			copy.setSectionId(book.getSectionId());
			copy.setLayerId(book.getLayerId());
			Copy createdCopy = copyRepository.save(copy);
			createdSlot.setCopyId(createdCopy.getCopyId());
			slotRepository.save(createdSlot);
		}
	}

	@Override
	public List<Book> findFeatured() {
		return bookRepository.findFeatured();
	}

	@Override
	public List<Book> search(String bookName) {
		return bookRepository.search(bookName);
	}

	@Override
	public Book findOne(Long bookId) {
		return bookRepository.findById(bookId).get();
	}

}
