package com.softbank.app.gold.controller;

import com.softbank.app.gold.service.MetalService;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/metals")
public class RatingController {

  private final MetalService metalService;

  @GetMapping
  public ResponseEntity<String> getRates(@RequestParam String base, @RequestParam(required = false) List<String> currencies) throws IOException {
    return ResponseEntity.ok(metalService.getRates(base, currencies));
  }

}
