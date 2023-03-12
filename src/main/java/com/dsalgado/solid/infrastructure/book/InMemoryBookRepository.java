package com.dsalgado.solid.infrastructure.book;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookDoesNotExists;
import com.dsalgado.solid.domain.BookRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component("InMemoryBookRepository")
public class InMemoryBookRepository implements BookRepository {

  private static Map<String, Book> books = new HashMap<>();

  @Override
  public void save(Book book) {
    books.put(book.getISBN(), book);
  }

  @Override
  public Book find(String ISBN) {
    return books.get(ISBN);
  }

  @Override
  public void update(Book book) {
    checkBook(book.getISBN());
    books.put(book.getISBN(), book);
  }

  @Override
  public void delete(String ISBN) {
    checkBook(ISBN);
    books.remove(ISBN);
  }

  private void checkBook(String ISBN) {
    if (books.get(ISBN) == null) {
      throw new BookDoesNotExists();
    }
  }
}
