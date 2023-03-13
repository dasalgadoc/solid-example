package com.dsalgado.solid.infrastructure.bookentrypoint;

import com.dsalgado.solid.application.book.BookGetter;
import com.dsalgado.solid.domain.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpBookFinder {
  @Autowired private BookGetter bookGetter;

  @GetMapping("/book")
  public ResponseEntity<BookDto> getBook(@RequestParam("isbn") String ISBN) {
    Book book = bookGetter.get(ISBN);
    BookDto response =
        BookDto.builder()
            .ISBN(book.getISBN())
            .author(book.getAuthor())
            .title(book.getTitle())
            .build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
