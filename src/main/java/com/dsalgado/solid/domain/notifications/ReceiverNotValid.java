package com.dsalgado.solid.domain.notifications;

public class ReceiverNotValid extends RuntimeException {
  public ReceiverNotValid() {
    super("Receiver is not valid");
  }
}
