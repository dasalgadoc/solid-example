package com.dsalgado.solid.domain.events;

public interface Observer<T extends DomainEvent> {
  <T extends DomainEvent> void update(T event);
}
