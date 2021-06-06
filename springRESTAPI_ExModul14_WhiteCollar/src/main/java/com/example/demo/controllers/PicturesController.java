package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.models.Picture;
import com.example.demo.models.Shop;
import com.example.demo.services.PicturesService;
import com.example.demo.services.ShopsService;

@RestController
@RequestMapping("/pictures")
public class PicturesController {
	
	@Autowired
	PicturesService pictureService;
	@Autowired
	ShopsService shopService;
	
	//return to index.html
	@GetMapping("/home")
	public String returnToIndex(Model model) {
		return "index";
	}
	
	//gets all pictures
	@GetMapping("/pictures")
	public String getAllPictures(Model model) {
			
		List<Picture> listPictures = pictureService.getAllPictures();
		model.addAttribute("listPictures", listPictures);
		return "list-pictures";
	}
	
	//go to createPicture-form.html
	@GetMapping ("/pictures/new")
	public String showNewPictureForm (Model model) {
		
		List<Shop> listShops = shopService.getAllShops();
		model.addAttribute("picture", new Picture());
		model.addAttribute("listShops", listShops);
		return "createPicture-form";
	}
		
	//create new picture
	@PostMapping("/shops/{id}(pictures")
	public String createPicture(Model model, Picture picture) {
		
		pictureService.createPicture(picture);
		List<Picture> listPictures = pictureService.getAllPictures();
		model.addAttribute("listPictures", listPictures);
		return "list-pictures";
	}
	
	//get picture from a shop by id
	@GetMapping("/shops/pictures/{id}")
	public String getById(Model model, @PathVariable(name = "id") Long id) throws RecordNotFoundException {
		
		List<Picture> listPictures = (List<Picture>) pictureService.getById(id);
		model.addAttribute("listPIctures", listPictures);
		return "list-pictures";
	}
	
	//delete picture from a shop by id
		@GetMapping("pictures/delete/{id}")
		public String deleteById(Model model, @PathVariable(name ="id") Long id) throws RecordNotFoundException{
			pictureService.deleteById(id);
			List<Picture> listPictures = pictureService.getAllPictures();
			model.addAttribute("listPictures", listPictures);
			return "list-pictures";
		}

}
