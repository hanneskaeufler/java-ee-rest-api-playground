package com.fastapps.books;

import static org.junit.Assert.*;
import static org.valid4j.matchers.http.HttpResponseMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.fastapps.books.api.BookResource;
import com.fastapps.books.api.BooksApiApplication;

@RunWith(Arquillian.class)
public class BookResourceTest {

	@Deployment(testable = false)
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "booksapi-web-integration-tests.war")
				.addClass(Book.class)
				.addClass(BookRepository.class)
				.addClass(BookResource.class)
				.addClass(BooksApiApplication.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void test_showOne_returnsBookJson(@ArquillianResteasyResource("api") WebTarget webTarget) {
		Response response = webTarget
				.path("books/1")
				.request(MediaType.APPLICATION_JSON)
				.get();

		assertThat(response, hasStatusCode(200));
		assertThat(response, hasEntity(equalTo("{\"title\":\"Working with Legacy Code\"}")));
		response.close();
	}
}
