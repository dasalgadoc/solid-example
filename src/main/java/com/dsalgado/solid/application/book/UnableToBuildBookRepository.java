package com.dsalgado.solid.application.book;

public class UnableToBuildBookRepository extends RuntimeException {
  public UnableToBuildBookRepository() {
    super("Unable to build book repository");
  }
}
