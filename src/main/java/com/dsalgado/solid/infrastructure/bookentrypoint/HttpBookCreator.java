package com.dsalgado.solid.infrastructure.bookentrypoint;

import com.dsalgado.solid.application.book.BookCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpBookCreator {
  @Autowired private BookCreator bookCreator;

  @PostMapping("/book")
  public HttpStatus createBook(@RequestBody BookDto bookDto) {
    bookCreator.create(bookDto.getISBN(), bookDto.getAuthor(), bookDto.getTitle());
    return HttpStatus.OK;
  }
}
