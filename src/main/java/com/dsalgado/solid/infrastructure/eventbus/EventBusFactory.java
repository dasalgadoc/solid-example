package com.dsalgado.solid.infrastructure.eventbus;

import com.dsalgado.solid.domain.EventBus;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EventBusFactory {
  @Resource private List<EventBus> eventBuses;

  @Value("${event_bus}")
  private String eventBusName;

  private Optional<EventBus> retrieveEventBus() {
    return eventBuses.stream()
        .filter(eventBus -> eventBusName.equals(eventBus.getClass().getSimpleName()))
        .findFirst();
  }

  public EventBus getBookRepository() {
    Optional<EventBus> eventBus = retrieveEventBus();
    if (!eventBus.isPresent()) {
      throw new UnableToBuildEventBus();
    }
    return eventBus.get();
  }
}
