package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Shop;
import com.example.demo.services.PicturesService;
import com.example.demo.services.ShopsService;

@RestController
@RequestMapping
public class ShopsController {
	
	@Autowired
	ShopsService shopService;
	
	//return to index.html
	@GetMapping("/home")
	public String returnToIndex(Model model) {
		return "index";
	}

	//get all shops
	@GetMapping("/shops")
	public String getAllShops (Model model) {
			
		List<Shop> listShops = shopService.getAllShops();
		model.addAttribute("listShops", listShops);
		return "list-shops";
	}
	
	//go to createShop-form.html
	@GetMapping("/shops/new")
	public String showNewShopForm (Model model) {
		
		model.addAttribute("shop", new Shop());
		return "createShop-form";
	}
	
	//create new shop
	@PostMapping("/shops/")
	public String createShop (Model model, Shop shop) {
		
		shopService.createShop(shop);
		List<Shop> listShop = shopService.getAllShops();
		model.addAttribute("listShops", listShop);
		return "list-shops";
	}
}
