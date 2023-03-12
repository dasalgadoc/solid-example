package com.dsalgado.solid.infrastructure.eventbus;

public class UnableToBuildEventBus extends RuntimeException {
  public UnableToBuildEventBus() {
    super("Unable to build event bus");
  }
}
