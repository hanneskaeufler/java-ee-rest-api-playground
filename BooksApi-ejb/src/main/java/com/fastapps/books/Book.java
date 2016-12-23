package com.fastapps.books;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {
	@NotNull
	@Size(min = 1, max = 100)
	private String title;

	public String getTitle() {
		return this.title;
	}

	public Book setTitle(String title) {
		this.title = title;

		return this;
	}
}
