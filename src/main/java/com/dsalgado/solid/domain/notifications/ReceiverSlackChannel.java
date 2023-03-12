package com.dsalgado.solid.domain.notifications;

public class ReceiverSlackChannel extends NotificationReceiver {
  private String slackChannel;

  public ReceiverSlackChannel(String slackChannel) {
    if (!isReceiverValid(slackChannel)) {
      throw new ReceiverNotValid();
    }
    this.slackChannel = slackChannel;
  }

  @Override
  public String receiver() {
    return slackChannel;
  }

  @Override
  protected boolean isReceiverValid(String receiver) {
    return !receiver.isEmpty();
  }
}
