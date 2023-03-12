package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookGetter {
  @Autowired
  @Qualifier("InMemoryBookRepository")
  private BookRepository bookRepository;

  public Book get(String ISBN) {
    return bookRepository.find(ISBN);
  }
}
