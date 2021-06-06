package com.example.demo.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.models.Shop;
import com.example.demo.repositoriesDAO.ShopsDAO;

@Service
public class ShopsService {
	
	@Autowired
	ShopsDAO shopsDAO;
	
	//create new shop
	public Shop createShop(Shop shop) {
		return shopsDAO.save(shop);
	}

	//get all shops
	public List<Shop> getAllShops() {
		return shopsDAO.findAll();
	}
	
	//get shop by id
	public Shop getById(Long id) throws RecordNotFoundException{
		
		return shopsDAO.findById(id)
				.orElseThrow(() -> new RecordNotFoundException ("No shops available for given id: " + id));
	}
	
	//get shop by name
	public List<Shop> getByName(String name) throws RecordNotFoundException {
			return shopsDAO.findByName(name);
	}
	
	//update shop by id
	public Shop updateById(Shop shop) {
		return shopsDAO.save(shop);
	}
	
	//delete by id
	public void deleteById(Long id) throws RecordNotFoundException{
		Optional<Shop> shop = shopsDAO.findById(id);
		
		if(shop.isPresent()) {
			shopsDAO.deleteById(id);
		} else {
			throw new RecordNotFoundException ("No shops available for given id: " + id);
		}
	}
}
