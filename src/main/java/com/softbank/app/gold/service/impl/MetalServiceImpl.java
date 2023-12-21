package com.softbank.app.gold.service.impl;

import com.softbank.app.gold.service.MetalService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class MetalServiceImpl implements MetalService {

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
