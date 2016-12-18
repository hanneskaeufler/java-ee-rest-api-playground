package com.fastapps.books.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fastapps.books.Book;
import com.fastapps.books.BookRepository;

@Path("/books")
public class BookResource {
	@Inject
	private BookRepository booksRepo;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book showBook(@PathParam("id") int id) {
		return booksRepo.findOne(id);
	}
}
