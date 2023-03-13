package com.dsalgado.solid.application.notifications;

import com.dsalgado.solid.domain.events.BookCreatedDomainEvent;
import com.dsalgado.solid.domain.events.DomainEvent;
import com.dsalgado.solid.domain.events.Observer;
import com.dsalgado.solid.domain.notifications.MultipleSender;
import com.dsalgado.solid.domain.notifications.NotificationContent;
import com.dsalgado.solid.domain.notifications.NotificationSubject;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookCreateNotificationHandler implements Observer<BookCreatedDomainEvent> {
  @Resource private List<MultipleSender> notificationSenders;

  @Override
  public <T extends DomainEvent> void update(T event) {
    BookCreatedDomainEvent bookCreatedDomainEvent = (BookCreatedDomainEvent) event;
    NotificationSubject notificationSubject =
        new NotificationSubject(bookCreatedDomainEvent.eventName());
    NotificationContent notificationContent =
        new NotificationContent(
            String.format("New book (%s) created!", bookCreatedDomainEvent.getISBN()));

    notificationSenders.stream()
        .forEach(
            notificationSender ->
                notificationSender.sendToMultipleDestination(
                    notificationSubject, notificationContent));
  }
}
