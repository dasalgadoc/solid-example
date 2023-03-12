package com.dsalgado.solid.domain.notifications;

public interface Notifiable {
  <T extends NotificationReceiver> void sendNotification(
      T receiver, NotificationSubject subject, NotificationContent content);
}
