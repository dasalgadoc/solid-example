package com.dsalgado.solid.domain;

public class BookCreatedDomainEvent extends DomainEvent {
  public static final String EVENT_NAME = "book_created";
  private String ISBN;

  public BookCreatedDomainEvent(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getISBN() {
    return ISBN;
  }

  @Override
  public String eventName() {
    return BookCreatedDomainEvent.EVENT_NAME;
  }
}
