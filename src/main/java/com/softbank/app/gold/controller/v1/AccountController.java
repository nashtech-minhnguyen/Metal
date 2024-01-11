package com.softbank.app.gold.controller.v1;

import com.softbank.app.gold.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/accounts")
public class AccountController {

  private final AccountService accountService;

  @PostMapping
  public ResponseEntity<Void> createAccount(){
    accountService.createAccount();
    return ResponseEntity.noContent().build();
  }

}
