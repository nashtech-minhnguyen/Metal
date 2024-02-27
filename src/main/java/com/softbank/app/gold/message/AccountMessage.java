package com.softbank.app.gold.message;

import com.softbank.app.gold.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountMessage {

  private final AccountService accountService;

  @KafkaListener(topics = "${kafka.topic.create-account}", groupId = "softbank")
  public void listen(String accountCode) {
    accountService.createAccount(accountCode);
  }
}
