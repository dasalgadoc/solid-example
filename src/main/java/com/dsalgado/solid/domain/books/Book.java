package com.dsalgado.solid.domain.books;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
  private String ISBN;
  private String title;
  private String author;
  private String currentPage;

  public Book replaceValues(String author, String title) {
    return Book.builder().ISBN(this.ISBN).author(author).title(title).build();
  }
}
