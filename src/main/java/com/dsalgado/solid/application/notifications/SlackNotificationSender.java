package com.dsalgado.solid.application.notifications;

import com.dsalgado.solid.domain.notifications.Notifiable;
import com.dsalgado.solid.domain.notifications.NotificationContent;
import com.dsalgado.solid.domain.notifications.NotificationReceiver;
import com.dsalgado.solid.domain.notifications.NotificationSubject;
import org.springframework.stereotype.Service;

@Service
public class SlackNotificationSender implements Notifiable {
  @Override
  public <T extends NotificationReceiver> void sendNotification(
      T receiver, NotificationSubject subject, NotificationContent content) {
    throw new RuntimeException("TODO");
  }
}
