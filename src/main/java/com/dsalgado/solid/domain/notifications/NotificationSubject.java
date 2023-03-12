package com.dsalgado.solid.domain.notifications;

public class NotificationSubject {
  private String subject;

  public NotificationSubject(String subject) {
    if (subject.length() > 140) {
      throw new SubjectIsTooLong();
    }
    this.subject = subject;
  }

  public String getSubject() {
    return subject;
  }
}
