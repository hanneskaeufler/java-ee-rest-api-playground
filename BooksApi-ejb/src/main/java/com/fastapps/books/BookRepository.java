package com.fastapps.books;

import javax.ejb.Stateless;

@Stateless
public class BookRepository {

	public Book findOne() {
		return new Book().setTitle("Working with Legacy Code");
	}

}
