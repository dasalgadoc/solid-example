package com.dsalgado.solid.infrastructure.eventbus;

import com.dsalgado.solid.domain.events.DomainEvent;
import com.dsalgado.solid.domain.events.EventBus;
import com.dsalgado.solid.domain.events.Observer;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component("InMemoryEventBus")
public class InMemoryEventBus implements EventBus {

  private final Map<String, List<Observer<? extends DomainEvent>>> observers;

  public InMemoryEventBus(Map<String, List<Observer<? extends DomainEvent>>> observers) {
    this.observers = observers;
  }

  @Override
  public <T extends DomainEvent> void notify(T event) {
    List<Observer<? extends DomainEvent>> observerList = this.observers.get(event.eventName());

    if (observerList != null) {
      observerList.forEach(observer -> observer.update(event));
    }
  }
}
