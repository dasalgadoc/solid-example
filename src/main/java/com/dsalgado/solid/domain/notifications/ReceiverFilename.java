package com.dsalgado.solid.domain.notifications;

public class ReceiverFilename extends NotificationReceiver {
  private String path;

  public ReceiverFilename(String path) {
    this.path = path;
  }

  @Override
  public String receiver() {
    return path;
  }

  @Override
  protected boolean isReceiverValid(String receiver) {
    return true;
  }
}
