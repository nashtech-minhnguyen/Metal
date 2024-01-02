package com.softbank.app.gold.client.impl;

import com.softbank.app.gold.client.MetalPriceApiClient;
import com.softbank.app.gold.dto.MetalPriceApiDto;
import com.softbank.app.gold.exception.NetworkException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
@Component
@Slf4j
public class MetalPriceApiClientImpl implements MetalPriceApiClient {

  @Value("${metal-price-api.api.key}")
  private String API_KEY;

  @Value("${metal-price-api.url}")
  private String METAL_PRICE_URL;

  @Autowired
  private final WebClient webClient;

  @Override
  public MetalPriceApiDto getRates(String base) {
    return webClient
        .get()
        .uri(METAL_PRICE_URL, uriBuilder ->
            uriBuilder.queryParam("api_key", API_KEY).queryParam("base", base).build())
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .retrieve()
        .bodyToMono(MetalPriceApiDto.class)
        .doOnError(error -> {
          throw new NetworkException("Can not get information from MetalAPI");
        })
        .block();
  }
}
