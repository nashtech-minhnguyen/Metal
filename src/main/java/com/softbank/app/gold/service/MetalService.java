package com.softbank.app.gold.service;

import com.softbank.app.gold.dto.MetalPriceApiDto;

import java.io.IOException;
import java.util.List;

public interface MetalService {

  String getRates(String base, List<String> currencies) throws IOException;

  void updateRates(String base);

}
