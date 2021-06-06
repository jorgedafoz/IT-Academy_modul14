package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.models.Picture;
import com.example.demo.repositoriesDAO.PicturesDAO;

@Service
public class PicturesService {

	@Autowired
	PicturesDAO picturesDAO;
	
	//create new picture
	public Picture createPicture(Picture picture) {
		return picturesDAO.save(picture);
	}
	
	//get all pictures
	public List<Picture> getAllPictures() {
		return picturesDAO.findAll();
	}
	
	//get picture by id
	public Picture getById(Long id) throws RecordNotFoundException{
			
		return picturesDAO.findById(id)
					.orElseThrow(() -> new RecordNotFoundException ("No picture available for given id: " + id));
	}
	
	//get picture by title
	public List<Picture> getByTitle(String title) {
		return picturesDAO.findByTitle(title);
	}
	
	//update picture by id
	public Picture updateById(Picture picture) {
		return picturesDAO.save(picture);
	}
	
	//delete by id
	public void deleteById(Long id) throws RecordNotFoundException{
		
		//we use Optional,since we cannot use .orElseThrow because here we expect a void return.
		Optional<Picture> picture = picturesDAO.findById(id);
		
		if (picture.isPresent()) {
			picturesDAO.deleteById(id);
		} else {
			throw new RecordNotFoundException("No picture available for given id: " + id);
		}	
	}
}
