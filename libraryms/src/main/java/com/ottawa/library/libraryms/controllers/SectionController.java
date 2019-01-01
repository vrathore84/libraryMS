package com.ottawa.library.libraryms.controllers;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ottawa.library.libraryms.models.Layer;
import com.ottawa.library.libraryms.models.Section;
import com.ottawa.library.libraryms.models.Shelf;
import com.ottawa.library.libraryms.services.SectionService;

@Controller
public class SectionController {
	
@Autowired
private SectionService sectionService;

@RequestMapping(value="/admin/sections",method = RequestMethod.GET)
public String sectionpage(Model sections){
	sections.addAttribute("sections", sectionService.getAllSections() );
	return "section";
}


@RequestMapping(value="/admin/deleteSection",method = RequestMethod.POST)
public String deleteSection(Model sections){
	sections.addAttribute("sections", sectionService.getAllSections() );
	return "section";
}

@RequestMapping(value="/admin/addSection",method = RequestMethod.POST)
public String addSection(Model sections, Section section){
	sectionService.addSection(section);
	sections.addAttribute("sections", sectionService.getAllSections() );
	return "section";
}

@RequestMapping(value="/admin/section/getShelves",method = RequestMethod.GET)
public @ResponseBody HashMap<Long, String>   getSectionShelves(Long sectionId ,Model sections){
	Set<Shelf> shelfSet = sectionService.getShelfBySection(sectionId); 
	HashMap<Long,String>  shelfMap = new HashMap<Long,String>();
	for(Shelf shelf : shelfSet){
		shelfMap.put(shelf.getShelfId(), shelf.getShelfName());
	}
	 return shelfMap;
}

@RequestMapping(value="/admin/shelf/getLayers",method = RequestMethod.GET)
public @ResponseBody HashMap<Long, String>   getShelfLayers(Long shelfId ,Model sections){
	Set<Layer> layerSet = sectionService.getLayerByShelf(shelfId); 
	HashMap<Long,String>  layerMap = new HashMap<Long,String>();
	for(Layer layer : layerSet){
		layerMap.put(layer.getLayerId(), layer.getLayerName());
	}
	 return layerMap;
}
}
