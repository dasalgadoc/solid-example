package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.books.Book;
import com.dsalgado.solid.domain.books.BookRepository;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookGetter {

  @Resource private BookRepositoryFactory bookRepositoryFactory;
  private BookRepository bookRepository;

  @PostConstruct
  public void initializer() {
    bookRepository = bookRepositoryFactory.getBookRepository();
  }

  public Book get(String ISBN) {
    return bookRepository.find(ISBN);
  }
}
