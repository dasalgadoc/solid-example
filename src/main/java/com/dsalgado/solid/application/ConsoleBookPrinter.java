package com.dsalgado.solid.application;

import com.dsalgado.solid.domain.Book;
import com.dsalgado.solid.domain.BookFormatter;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class ConsoleBookPrinter implements BookFormatter {

  public void printBook(Book book) {
    System.out.println(formatBook(book));
  }

  @Override
  public String formatBook(Book book) {
    return String.format(
        "%s - %s\n%s",
        book.getAuthor().toUpperCase(Locale.ROOT), book.getTitle(), book.getCurrentPage());
  }
}
