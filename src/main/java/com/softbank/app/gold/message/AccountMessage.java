package com.softbank.app.gold.message;

import com.softbank.app.gold.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountMessage {

  @Value("kafka.topic.create-account")
  private String KAFKA_TOPIC_CREATE_ACCOUNT;

  private final AccountService accountService;

  @KafkaListener(topics = "createAccount", groupId = "softbank")
  public void listen(String accountCode) {
    accountService.createAccount(accountCode);
  }
}
