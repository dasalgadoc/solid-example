package com.dsalgado.solid.domain.notifications;

public abstract class NotificationReceiver {
  public abstract String receiver();

  protected abstract boolean isReceiverValid(String receiver);
}
