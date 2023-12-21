package com.softbank.app.gold.service;

import java.io.IOException;
import java.util.List;

public interface MetalService {

  String getRates(String base, List<String> currencies) throws IOException;

}
