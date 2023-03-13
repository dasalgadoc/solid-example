package com.dsalgado.solid.domain.books;

public interface BookRepository {
  void save(Book book);

  Book find(String ISBN);

  void update(Book book);

  void delete(String ISBN);
}
