package com.dsalgado.solid.domain;

public interface Observer<T extends DomainEvent> {
  <T extends DomainEvent> void update(T event);
}
