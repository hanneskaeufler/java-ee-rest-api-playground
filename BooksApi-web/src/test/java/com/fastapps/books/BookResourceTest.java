package com.fastapps.books;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.valid4j.matchers.http.HttpResponseMatchers.hasEntity;
import static org.valid4j.matchers.http.HttpResponseMatchers.hasStatusCode;

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
		return ShrinkWrap.create(WebArchive.class, "booksapi-web-integration-tests.war").addClass(Book.class)
				.addClass(BookRepository.class).addClass(BookResource.class).addClass(NotFoundException.class)
				.addClass(BooksApiApplication.class).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void test_showOne_returnsBookJson(@ArquillianResteasyResource("api") WebTarget webTarget) {
		Response response = webTarget.path("books/1").request(MediaType.APPLICATION_JSON).get();

		assertThat(response, hasStatusCode(200));
		assertThat(response, hasEntity(equalTo("{\"title\":\"Working with Legacy Code\"}")));
		response.close();
	}

	@Test
	public void test_showOne_returnsNotFound(@ArquillianResteasyResource("api") WebTarget webTarget) {
		Response response = webTarget.path("books/2").request(MediaType.APPLICATION_JSON).get();

		assertThat(response, hasStatusCode(404));
		assertThat(response, hasEntity(containsString("not available")));
		response.close();
	}
}
