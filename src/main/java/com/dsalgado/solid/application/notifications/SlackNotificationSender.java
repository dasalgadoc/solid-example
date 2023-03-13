package com.dsalgado.solid.application.notifications;

import com.dsalgado.solid.domain.notifications.MultipleSender;
import com.dsalgado.solid.domain.notifications.Notifiable;
import com.dsalgado.solid.domain.notifications.NotificationContent;
import com.dsalgado.solid.domain.notifications.NotificationReceiver;
import com.dsalgado.solid.domain.notifications.NotificationSubject;
import com.dsalgado.solid.domain.notifications.ReceiverSlackChannel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SlackNotificationSender implements Notifiable, MultipleSender {

  private final List<ReceiverSlackChannel> slackChannelList;

  public SlackNotificationSender(List<ReceiverSlackChannel> slackChannelList) {
    this.slackChannelList = slackChannelList;
  }

  @Override
  public <T extends NotificationReceiver> void sendNotification(
      T receiver, NotificationSubject subject, NotificationContent content) {
    throw new RuntimeException("TODO");
  }

  @Override
  public void sendToMultipleDestination(NotificationSubject subject, NotificationContent content) {
    slackChannelList.stream()
        .forEach(slackChannel -> sendNotification(slackChannel, subject, content));
  }
}
