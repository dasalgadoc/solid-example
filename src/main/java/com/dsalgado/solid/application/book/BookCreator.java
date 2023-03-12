package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookCreatedDomainEvent;
import com.dsalgado.solid.domain.BookRepository;
import com.dsalgado.solid.domain.EventBus;
import com.dsalgado.solid.infrastructure.eventbus.EventBusFactory;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookCreator {

  @Resource private BookRepositoryFactory bookRepositoryFactory;
  private BookRepository bookRepository;

  @Resource private EventBusFactory eventBusFactory;
  private EventBus eventBus;

  @PostConstruct
  public void initializer() {
    bookRepository = bookRepositoryFactory.getBookRepository();
    eventBus = eventBusFactory.getBookRepository();
  }

  public void create(String ISBN, String author, String title) {
    Book book = Book.builder().ISBN(ISBN).author(author).title(title).build();
    bookRepository.save(book);

    eventBus.notify(new BookCreatedDomainEvent(ISBN));
  }
}
