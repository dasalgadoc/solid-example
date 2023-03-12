package com.dsalgado.solid.application.logger;

import com.dsalgado.solid.domain.BookCreatedDomainEvent;
import com.dsalgado.solid.domain.DomainEvent;
import com.dsalgado.solid.domain.Observer;
import org.springframework.stereotype.Service;

@Service
public class NewBooksLogger implements Observer<BookCreatedDomainEvent> {

  @Override
  public <T extends DomainEvent> void update(T event) {
    BookCreatedDomainEvent bookCreatedDomainEvent = (BookCreatedDomainEvent) event;
    String log = String.format("---> NEW BOOK CREATED: %s", bookCreatedDomainEvent.getISBN());
    System.out.println(log);
  }
}
