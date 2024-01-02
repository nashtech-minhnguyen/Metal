package com.softbank.app.gold.service.impl;

import com.softbank.app.gold.client.MetalPriceApiClient;
import com.softbank.app.gold.dto.MetalPriceApiDto;
import com.softbank.app.gold.entity.Currency;
import com.softbank.app.gold.mapper.RateMapper;
import com.softbank.app.gold.repository.CurrencyRepository;
import com.softbank.app.gold.service.MetalService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetalServiceImpl implements MetalService {

  private final MetalPriceApiClient metalPriceApiClient;

  private final RateMapper rateMapper;

  private final CurrencyRepository currencyRepository;

  @Value("${metal-price-api.api.key}")
  private String API_KEY;

  @Value("${metal-price-api.url}")
  private String METAL_PRICE_URL;

  @Override
  public String getRates(String base, List<String> currencies) throws IOException {
    String url = this.buildUrl(base, currencies);
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url(url)
        .method("GET", null)
        .build();
    return client.newCall(request).execute().body().string();
  }

  @Override
  @Transactional
  public void updateRates(String base) {
    MetalPriceApiDto metalPriceApiDto =  metalPriceApiClient.getRates(base);
    Set<Currency> currencies = rateMapper.toCurrencyEntity(metalPriceApiDto);
    currencyRepository.saveAll(currencies);
  }

  private String buildUrl(String base, List<String> currencies) {
  String baseUrl= METAL_PRICE_URL.concat("?api_key=").concat(API_KEY).concat("&base=").concat(base);

    if (Objects.nonNull(currencies) && !currencies.isEmpty()) {
        baseUrl = baseUrl.concat("&currencies=");
       for (String currency : currencies) {
           baseUrl = baseUrl.concat(currency);
           if(currencies.indexOf(currency) < currencies.size() - 1) {
               baseUrl = baseUrl.concat(",");
           }
       }
    }
    return baseUrl;
  }
}
