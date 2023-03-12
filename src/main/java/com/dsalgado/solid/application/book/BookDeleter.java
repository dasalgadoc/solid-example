package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.BookRepository;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookDeleter {

  @Resource private BookRepositoryFactory bookRepositoryFactory;
  private BookRepository bookRepository;

  @PostConstruct
  public void initializer() {
    bookRepository = bookRepositoryFactory.getBookRepository();
  }

  public void delete(String ISBN) {
    bookRepository.delete(ISBN);
  }
}
