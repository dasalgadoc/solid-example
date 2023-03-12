package com.dsalgado.solid.domain;

public class BookDoesNotExists extends RuntimeException {
  public BookDoesNotExists() {
    super("Book does not exists");
  }
}
