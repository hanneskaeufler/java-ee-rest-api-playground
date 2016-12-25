package com.fastapps.books;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundException extends Exception implements ExceptionMapper<NotFoundException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6155929939016193087L;

	/**
	 * TODO: NotFoundException should not really know how to map itself to a
	 * response.
	 */
	@Override
	public Response toResponse(NotFoundException exception) {
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
