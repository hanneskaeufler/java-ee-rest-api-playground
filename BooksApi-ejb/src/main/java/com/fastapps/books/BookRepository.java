package com.fastapps.books;

import javax.ejb.Stateless;

@Stateless
public class BookRepository {

	public Book findOne(int id) throws NotFoundException {
		if (id == 1) {
			return new Book().setTitle("Working with Legacy Code");
		}

		throw new NotFoundException();
	}

}
