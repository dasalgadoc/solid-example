package com.dsalgado.solid.application.book;

import com.dsalgado.solid.domain.books.BookRepository;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookRepositoryFactory {
  @Resource private List<BookRepository> bookRepositories;

  @Value("${books.repository}")
  private String repositoryName;

  private Optional<BookRepository> retrieveBookRepository() {
    return bookRepositories.stream()
        .filter(bookRepository -> repositoryName.equals(bookRepository.getClass().getSimpleName()))
        .findFirst();
  }

  public BookRepository getBookRepository() {
    Optional<BookRepository> repository = retrieveBookRepository();
    if (!repository.isPresent()) {
      throw new UnableToBuildBookRepository();
    }
    return repository.get();
  }
}
