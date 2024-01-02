package com.softbank.app.gold.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class MetalPriceApiDto {

  @JsonProperty("success")
  private boolean success;

  @JsonProperty("base")
  private String base;

  @JsonProperty("timestamp")
  private Long timestamp;

  @JsonProperty("rates")
  private Map<String, BigDecimal> rates;
}
