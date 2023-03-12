package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookRepository;
import com.dsalgado.solid.domain.BookUpdatedDomainEvent;
import com.dsalgado.solid.domain.EventBus;
import com.dsalgado.solid.infrastructure.eventbus.EventBusFactory;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookUpdater {

  @Resource private BookRepositoryFactory bookRepositoryFactory;
  private BookRepository bookRepository;

  @Resource private EventBusFactory eventBusFactory;
  private EventBus eventBus;

  @PostConstruct
  public void initializer() {
    bookRepository = bookRepositoryFactory.getBookRepository();
    eventBus = eventBusFactory.getBookRepository();
  }

  public void update(String ISBN, String author, String title) {
    Book formerBook = bookRepository.find(ISBN);
    Book newBook = formerBook.replaceValues(author, title);
    bookRepository.update(newBook);
    eventBus.notify(new BookUpdatedDomainEvent(new Date(), formerBook, newBook));
  }
}
