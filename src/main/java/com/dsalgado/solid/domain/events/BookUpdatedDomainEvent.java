package com.dsalgado.solid.domain.events;

import com.dsalgado.solid.domain.books.Book;
import java.util.Date;

public class BookUpdatedDomainEvent extends DomainEvent {
  public static final String EVENT_NAME = "book_updated";
  private Date updateDate;
  private Book formerBook;
  private Book newBook;

  public BookUpdatedDomainEvent(Date updateDate, Book formerBook, Book newBook) {
    this.updateDate = updateDate;
    this.formerBook = formerBook;
    this.newBook = newBook;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public Book getFormerBook() {
    return formerBook;
  }

  public Book getNewBook() {
    return newBook;
  }

  @Override
  public String eventName() {
    return BookUpdatedDomainEvent.EVENT_NAME;
  }
}
