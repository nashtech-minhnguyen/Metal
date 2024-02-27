package com.softbank.app.gold.service.impl;

import com.softbank.app.gold.entity.Account;
import com.softbank.app.gold.repository.AccountRepository;
import com.softbank.app.gold.service.AccountService;
import com.softbank.common.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Override
  @Transactional
  public void createAccount(String accountCode) {
    Account account = new Account();
    account.setStatus(Status.ACTIVE);
    account.setAccountBalance(BigDecimal.ZERO);
    account.setLinkedAccountCode(accountCode);
    account.setCreatedWhen(LocalDateTime.now());
    account.setModifiedWhen(LocalDateTime.now());
    accountRepository.save(account);
  }
}
