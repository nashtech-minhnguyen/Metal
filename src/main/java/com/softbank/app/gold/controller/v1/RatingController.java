package com.softbank.app.gold.controller.v1;

import com.softbank.app.gold.service.MetalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/metals")
public class RatingController {

  private final MetalService metalService;

  @GetMapping
  public ResponseEntity<String> getRates(@RequestParam String base, @RequestParam(required = false) List<String> currencies) throws IOException {
    return ResponseEntity.ok(metalService.getRates(base, currencies));
  }

  @PostMapping
  public ResponseEntity<Void> updateRates(@RequestParam String base){
    metalService.updateRates(base);
    return ResponseEntity.noContent().build();
  }

}
