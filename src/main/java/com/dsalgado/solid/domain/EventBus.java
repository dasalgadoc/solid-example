package com.dsalgado.solid.domain;

public interface EventBus {
  <T extends DomainEvent> void notify(T event);
}
