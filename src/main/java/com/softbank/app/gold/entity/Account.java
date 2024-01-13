package com.softbank.app.gold.entity;

import com.softbank.common.enums.Status;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "money_accounts")
@Data
public class Account {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_balance")
    private BigDecimal accountBalance;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "linked_account_code")
    private String linkedAccountCode;

    public Account(Status status, String linkedAccountCode) {
        this.status = status;
        this.linkedAccountCode = linkedAccountCode;
    }
}
