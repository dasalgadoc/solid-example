package com.dsalgado.solid.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
  private String title;
  private String author;
  private String currentPage;
}
