package com.fastapps.books;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BookRepositoryTest {
  /**
   * Build the micro deployment for arquillian.
   * 
   * @return the archive to deploy
   */
  @Deployment
  public static WebArchive createDeployment() {
    return ShrinkWrap.create(WebArchive.class, "booksapi-ejb-integration-tests.war")
        .addClass(Book.class).addClass(BookRepository.class)
        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @Inject
  BookRepository bookRepo;

  @Test
  public void test_findOne_returnsBook() {
    Book book = bookRepo.findOne(1);

    assertNotNull(".findOne() must return a Book instance", book);
    assertEquals("Working with Legacy Code", book.getTitle());
  }

}
