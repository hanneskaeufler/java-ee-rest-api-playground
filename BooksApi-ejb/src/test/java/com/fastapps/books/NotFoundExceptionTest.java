package com.fastapps.books;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NotFoundExceptionTest {

	@Test
	public void test_toResponse_returns404Response() {
		NotFoundException subject = new NotFoundException();

		assertEquals(404, subject.toResponse(subject).getStatus());
	}
}
