package com.dsalgado.solid.infrastructure.bookentrypoint;

import com.dsalgado.solid.application.book.BookUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpBookUpdater {
  @Autowired private BookUpdater bookUpdater;

  @PutMapping("/book")
  public HttpStatus createBook(@RequestBody BookDto bookDto) {
    if (bookDto.getISBN() == null) {
      return HttpStatus.BAD_REQUEST;
    }
    bookUpdater.update(bookDto.getISBN(), bookDto.getAuthor(), bookDto.getTitle());
    return HttpStatus.OK;
  }
}
