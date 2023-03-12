package com.dsalgado.solid.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.dsalgado.solid.application.printer.ConsoleBookPrinter;
import com.dsalgado.solid.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsoleBookPrinterTest {

  @Autowired private ConsoleBookPrinter consolePrinter;

  @Test
  public void testBookServer() {
    // Given
    Book actualBook =
        Book.builder().title("Lorem Ipsum").author("John Doe").currentPage("Current page.").build();
    String expected = String.format("%s - %s\n%s", "JOHN DOE", "Lorem Ipsum", "Current page.");
    // Then
    assertEquals(expected, consolePrinter.formatBook(actualBook));
  }
}
