package com.dsalgado.solid.infrastructure.bookentrypoint;

import com.dsalgado.solid.application.book.BookDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpBookDeleter {
  @Autowired private BookDeleter bookDeleter;

  @DeleteMapping("/book")
  public HttpStatus deleteBook(@RequestParam("isbn") String ISBN) {
    bookDeleter.delete(ISBN);
    return HttpStatus.OK;
  }
}
