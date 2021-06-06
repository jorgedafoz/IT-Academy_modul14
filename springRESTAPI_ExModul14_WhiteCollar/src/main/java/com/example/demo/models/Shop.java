package com.example.demo.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer capacity;
	
	//@OnetoMany(mappedBy="shop")
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Picture.class) //mappedBy = "shop"
	@JoinColumn(name = "id")
	public List<Picture> pictures;
	
	//contructors
	public Shop() {
	}

	public Shop(Long id, String name, Integer capacity, List<Picture> pictures) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.pictures = pictures;
	}
	
	//getters & setters
	@JsonIgnore
	@JoinColumn(name = "id")
	public List<Picture> getPictures() {
		return pictures;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

}
