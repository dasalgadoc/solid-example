package com.dsalgado.solid.infrastructure.printer;

import com.dsalgado.solid.application.HtmlBookPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookPrinterController {
  @Autowired private HtmlBookPrinter htmlPrinter;

  @GetMapping("/printer")
  @ResponseBody
  public String printBook(
      @RequestParam("title") String title, @RequestParam("author") String author) {
    return htmlPrinter.serveBook(title, author);
  }
}
