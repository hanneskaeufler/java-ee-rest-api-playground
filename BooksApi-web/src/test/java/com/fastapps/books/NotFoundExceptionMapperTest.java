package com.fastapps.books;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fastapps.books.api.NotFoundExceptionMapper;

public class NotFoundExceptionMapperTest {

	@Test
	public void test_toResponse_returns404() {
		NotFoundException exception = new NotFoundException();
		NotFoundExceptionMapper subject = new NotFoundExceptionMapper();

		assertEquals(404, subject.toResponse(exception).getStatus());
	}

}
