package com.fastapps.books;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fastapps.books.BookRepository;

public class BookRepositoryTest {

	@Test
	public void test_findOne_returnsBook() {
		BookRepository bookRepo = new BookRepository();
		
		assertNotNull(".findOne() must return a Book instance", bookRepo.findOne());
	}

}
