package com.dsalgado.solid.infrastructure.eventbus;

import com.dsalgado.solid.application.logger.NewBooksLogger;
import com.dsalgado.solid.domain.BookCreatedDomainEvent;
import com.dsalgado.solid.domain.DomainEvent;
import com.dsalgado.solid.domain.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfiguration {

  @Bean
  public Map<String, List<Observer<? extends DomainEvent>>> observers() {
    Map<String, List<Observer<? extends DomainEvent>>> observers = new HashMap<>();

    List<Observer<? extends DomainEvent>> booksCreatedObservers = new ArrayList<>();
    booksCreatedObservers.add(new NewBooksLogger());
    observers.put(BookCreatedDomainEvent.EVENT_NAME, booksCreatedObservers);

    // add more observers here for other events

    return observers;
  }
}
