package com.fastapps.books;

import javax.persistence.Entity;

@Entity
public class Book {
	private String title;

	public String getTitle() {
		return this.title;
	}
	
	public Book setTitle(String title) {
		this.title = title;
		
		return this;
	}
}
