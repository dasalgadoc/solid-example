package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookRepository;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookUpdater {

  @Resource private BookRepositoryFactory bookRepositoryFactory;
  private BookRepository bookRepository;

  @PostConstruct
  public void initializer() {
    bookRepository = bookRepositoryFactory.getBookRepository();
  }

  public void update(String ISBN, String author, String title) {
    Book book = Book.builder().ISBN(ISBN).author(author).title(title).build();
    bookRepository.update(book);
  }
}
