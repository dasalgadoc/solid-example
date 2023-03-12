package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookCreator {
  @Autowired
  @Qualifier("InMemoryBookRepository")
  private BookRepository bookRepository;

  public void create(String ISBN, String author, String title) {
    Book book = Book.builder().ISBN(ISBN).author(author).title(title).build();
    bookRepository.save(book);
  }
}
