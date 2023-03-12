package com.dsalgado.solid.infrastructure.notifications;

import com.dsalgado.solid.domain.notifications.ReceiverSlackChannel;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackChannelConfiguration {

  @Bean
  public List<ReceiverSlackChannel> slackChannelList() {
    return List.of(new ReceiverSlackChannel("channel-name"));
  }
}
