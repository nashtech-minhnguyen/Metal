package com.softbank.app.gold.service.impl;

import com.softbank.app.gold.entity.Account;
import com.softbank.app.gold.repository.AccountRepository;
import com.softbank.app.gold.service.AccountService;
import com.softbank.common.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Override
  public void createAccount() {
    Account account = new Account();
    account.setAccountBalance(BigDecimal.ZERO);
    account.setStatus(Status.ACTIVE);
    accountRepository.save(account);
  }
}
