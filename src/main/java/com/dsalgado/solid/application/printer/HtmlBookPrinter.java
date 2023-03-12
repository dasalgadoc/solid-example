package com.dsalgado.solid.application.printer;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookFormatter;
import org.springframework.stereotype.Service;

@Service
public class HtmlBookPrinter implements BookFormatter {

  public String serveBook(String title, String author) {
    return formatBook(
        Book.builder()
            .author(author)
            .title(title)
            .currentPage("This page left was intentionally left blank")
            .build());
  }

  @Override
  public String formatBook(Book book) {
    return String.format(
        "<h1><strong>%s</strong> - %s</h1></br><p>%s</p>",
        book.getAuthor(), book.getTitle(), book.getCurrentPage());
  }
}
