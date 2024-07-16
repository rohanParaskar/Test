package com.boot.BootBlog.enity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String author;
	private LocalDateTime addedDate;
	private LocalDateTime updatedDate;
	public Blog(int id, String title, String description, String author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructor For update
	public Blog(String title, String description, LocalDateTime updatedDate) {
		super();
		this.title = title;
		this.description = description;
		this.updatedDate = updatedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDateTime getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(LocalDateTime localDateTime) {
		this.addedDate = localDateTime;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime localDateTime) {
		this.updatedDate = localDateTime;
	}
	
}
