package com.dsalgado.solid.domain.notifications;

public interface MultipleSender {
  void sendToMultipleDestination(NotificationSubject subject, NotificationContent content);
}
