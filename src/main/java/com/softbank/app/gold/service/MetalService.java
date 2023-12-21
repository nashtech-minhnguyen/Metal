package com.softbank.app.gold.service;

import com.squareup.okhttp.Response;

import java.io.IOException;

public interface MetalService {

    Response getXAURate() throws IOException;

}
