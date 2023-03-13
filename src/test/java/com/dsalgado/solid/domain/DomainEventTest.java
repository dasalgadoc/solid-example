package com.dsalgado.solid.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.dsalgado.solid.domain.books.Book;
import com.dsalgado.solid.domain.events.BookCreatedDomainEvent;
import com.dsalgado.solid.domain.events.BookUpdatedDomainEvent;
import com.dsalgado.solid.domain.events.DomainEvent;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DomainEventTest {
  @Test
  public void testAConcreteDomainEventCanBeUsedThroughItsFather_BookCreated() {
    // Given
    String expectedEventName = "book_created";
    String ISBN = "123A";
    DomainEvent domainEvent = new BookCreatedDomainEvent(ISBN);
    // When
    String actualEventName = domainEvent.eventName();
    // Then
    assertInstanceOf(DomainEvent.class, domainEvent);
    assertInstanceOf(BookCreatedDomainEvent.class, domainEvent);
    assertEquals(expectedEventName, actualEventName);
  }

  @Test
  public void testAConcreteDomainEventCanBeUsedThroughItsFather_BookUpdated() {
    // Given
    String expectedEventName = "book_updated";
    Book formerBook = Book.builder().build();
    Book newBook = Book.builder().build();
    DomainEvent domainEvent = new BookUpdatedDomainEvent(new Date(), formerBook, newBook);
    // When
    String actualEventName = domainEvent.eventName();
    // Then
    assertInstanceOf(DomainEvent.class, domainEvent);
    assertInstanceOf(BookUpdatedDomainEvent.class, domainEvent);
    assertEquals(expectedEventName, actualEventName);
  }
}
