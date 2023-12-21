package com.softbank.app.gold.service.impl;

import com.softbank.app.gold.service.MetalService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MetalServiceImpl implements MetalService {

    @Value("${}")
    private String API_KEY;

    @Override
    public Response getXAURate() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.metalpriceapi.com/v1/latest?api_key=7183ba58e2c429a45c30e778f258ca1b&base=XAU&currencies=USD")
                .method("GET", null)
                .build();
        return client.newCall(request).execute();
    }
}
