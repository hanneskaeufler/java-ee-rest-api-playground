package com.fastapps.books.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fastapps.books.NotFoundException;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
