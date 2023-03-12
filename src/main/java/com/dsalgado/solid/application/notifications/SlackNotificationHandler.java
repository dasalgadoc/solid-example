package com.dsalgado.solid.application.notifications;

import com.dsalgado.solid.domain.BookCreatedDomainEvent;
import com.dsalgado.solid.domain.DomainEvent;
import com.dsalgado.solid.domain.Observer;
import com.dsalgado.solid.domain.notifications.NotificationContent;
import com.dsalgado.solid.domain.notifications.NotificationSubject;
import com.dsalgado.solid.domain.notifications.ReceiverSlackChannel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlackNotificationHandler implements Observer<BookCreatedDomainEvent> {
  @Autowired private SlackNotificationSender slackNotificationSender;
  private final List<ReceiverSlackChannel> slackChannelList;

  public SlackNotificationHandler(List<ReceiverSlackChannel> slackChannelList) {
    this.slackChannelList = slackChannelList;
  }

  @Override
  public <T extends DomainEvent> void update(T event) {
    BookCreatedDomainEvent bookCreatedDomainEvent = (BookCreatedDomainEvent) event;
    NotificationSubject notificationSubject =
        new NotificationSubject(bookCreatedDomainEvent.eventName());
    NotificationContent notificationContent =
        new NotificationContent(
            String.format("New book (%s) created!", bookCreatedDomainEvent.getISBN()));

    slackChannelList.stream()
        .forEach(
            slackChannel ->
                slackNotificationSender.sendNotification(
                    slackChannel, notificationSubject, notificationContent));
  }
}
