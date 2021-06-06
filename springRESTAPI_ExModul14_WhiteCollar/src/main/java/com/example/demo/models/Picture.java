package com.example.demo.models;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Picture")
public class Picture {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String artist = "unknown";
	private double price;
	private final Calendar fecha = Calendar.getInstance();
	

	
	//@ManytoOne
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Shop.class)
	@JoinColumn(name = "shop_id")
	public Shop shop;
	
	//constructors
	public Picture() {
	}

	public Picture(Long id, String title, String artist, double price, Shop shop) {
		this.id = id;
		this.title = title;
		setArtist(artist);
		this.price = price;
		this.shop = shop;
	}

	//getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Calendar getDate() {
		return fecha;
	}
}
