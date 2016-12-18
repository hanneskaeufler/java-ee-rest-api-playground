package com.fastapps.books.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import com.fastapps.books.Book;
//import com.fastapps.books.BookRepository;

@Path("/books")
public class BookResource {
//	@Inject
//	private BookRepository booksRepo;

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String showBook() {
		return "Dude";
		//return booksRepo.findOne();
	}
}
