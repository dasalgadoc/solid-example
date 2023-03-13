package com.dsalgado.solid.domain.books;

public class BookDoesNotExists extends RuntimeException {
  public BookDoesNotExists() {
    super("Book does not exists");
  }
}
