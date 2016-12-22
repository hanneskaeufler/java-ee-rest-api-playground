package com.fastapps.books;

import javax.persistence.Entity;

@Entity
public class Book {
  private String title;

  public String getTitle() {
    return this.title;
  }

  /**
   * Set books title.
   * 
   * @param title The title to be set
   * @return the book
   */
  public Book setTitle(String title) {
    this.title = title;

    return this;
  }
}
