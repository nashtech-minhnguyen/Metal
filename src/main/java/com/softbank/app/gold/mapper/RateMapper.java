package com.softbank.app.gold.mapper;

import com.softbank.app.gold.dto.MetalPriceApiDto;
import com.softbank.app.gold.entity.Currency;

import java.util.Set;

public interface RateMapper {

  Set<Currency> toCurrencyEntity(MetalPriceApiDto metalPriceApiDto);
}
