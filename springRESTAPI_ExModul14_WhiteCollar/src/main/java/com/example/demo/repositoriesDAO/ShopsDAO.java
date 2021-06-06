package com.example.demo.repositoriesDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Shop;

@Repository
public interface ShopsDAO extends JpaRepository<Shop, Long>{
	
	
	//find by name
	public List<Shop> findByName(String name);

}
