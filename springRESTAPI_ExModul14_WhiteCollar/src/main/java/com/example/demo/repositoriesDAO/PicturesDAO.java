package com.example.demo.repositoriesDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Picture;

@Repository
public interface PicturesDAO extends JpaRepository<Picture, Long>{

	
	//find by title
		public List<Picture> findByTitle(String name);
		
		//find by artist
		public List<Picture> findByArtist(String artist);
		
		//find by shop
		public List<Picture> findByShop(String name);

}
