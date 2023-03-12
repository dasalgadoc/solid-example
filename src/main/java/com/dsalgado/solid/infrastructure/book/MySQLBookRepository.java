package com.dsalgado.solid.infrastructure.book;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookRepository;
import org.springframework.stereotype.Component;

@Component("MySQLBookRepository")
public class MySQLBookRepository implements BookRepository {
  @Override
  public void save(Book book) {
    throw new RuntimeException("Not implemented yet");
  }

  @Override
  public Book find(String ISBN) {
    throw new RuntimeException("Not implemented yet");
  }

  @Override
  public void update(Book book) {
    throw new RuntimeException("Not implemented yet");
  }

  @Override
  public void delete(String ISBN) {
    throw new RuntimeException("Not implemented yet");
  }
}
