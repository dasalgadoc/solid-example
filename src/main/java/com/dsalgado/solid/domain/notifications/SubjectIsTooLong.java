package com.dsalgado.solid.domain.notifications;

public class SubjectIsTooLong extends RuntimeException {
  public SubjectIsTooLong() {
    super("Subject is too long, it has to be 140 characters or less");
  }
}
