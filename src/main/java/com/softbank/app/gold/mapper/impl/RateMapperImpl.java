package com.softbank.app.gold.mapper.impl;

import com.softbank.app.gold.dto.MetalPriceApiDto;
import com.softbank.app.gold.entity.Currency;
import com.softbank.app.gold.mapper.RateMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RateMapperImpl implements RateMapper {

  @Override
  public Set<Currency> toCurrencyEntity(MetalPriceApiDto metalPriceApiDto) {
    Map<String, BigDecimal> rates = metalPriceApiDto.getRates();
    return rates.keySet().stream().map(key -> {
      Currency currency = new Currency();
      currency.setBaseCurrency(metalPriceApiDto.getBase());
      currency.setQuoteCurrency(key);
      currency.setTime(LocalDateTime.now());
      currency.setAmountInBase(rates.get(key));
      return currency;
    }).collect(Collectors.toSet());
  }

}
