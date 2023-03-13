package com.dsalgado.solid.domain.events;

public interface EventBus {
  <T extends DomainEvent> void notify(T event);
}
