package com.dsalgado.solid.domain;

public interface BookRepository {
  void save(Book book);

  Book find(String ISBN);

  void update(Book book);

  void delete(String ISBN);
}
