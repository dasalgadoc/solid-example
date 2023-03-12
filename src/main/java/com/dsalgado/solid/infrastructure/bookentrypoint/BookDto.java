package com.dsalgado.solid.infrastructure.bookentrypoint;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
  @JsonProperty("isbn")
  private String ISBN;

  @JsonProperty("title")
  private String title = "";

  @JsonProperty("author")
  private String author = "";
}
