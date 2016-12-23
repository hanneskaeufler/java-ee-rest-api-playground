package com.fastapps.books.api;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fastapps.books.Book;
import com.fastapps.books.BookRepository;
import com.fastapps.books.NotFoundException;

@Path("/books")
public class BookResource {
	@Inject
	private BookRepository booksRepo;

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book showBook(@PathParam("id") int id) throws NotFoundException {
		return booksRepo.findOne(id);
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editBook(@PathParam("id") int id, Book book) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

		if (constraintViolations.isEmpty()) {
			return Response.ok().entity(book).build();
		}

		return Response.status(Response.Status.BAD_REQUEST).build();
	}
}
