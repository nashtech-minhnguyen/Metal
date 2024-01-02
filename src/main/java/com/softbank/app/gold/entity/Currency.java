package com.softbank.app.gold.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "currency")
public class Currency {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "base_currency")
  private String baseCurrency;

  @Column(name = "quote_currency")
  private String quoteCurrency;

  @Column(name = "time")
  private LocalDateTime time;

  @Column(name = "amount_in_base")
  private BigDecimal amountInBase;


}
