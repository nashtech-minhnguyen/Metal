package com.softbank.app.gold.client;

import com.softbank.app.gold.dto.MetalPriceApiDto;

public interface MetalPriceApiClient {

  MetalPriceApiDto getRates(String base);

}
