package com.softbank.app.gold.controller.v2;

import com.softbank.app.gold.dto.MetalPriceApiDto;
import com.softbank.app.gold.service.MetalService;
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
@RequestMapping("/v2/metals")
public class RatingControllerV2 {

    private final MetalService metalService;

    @GetMapping
    public ResponseEntity<MetalPriceApiDto> getRates(@RequestParam String base, @RequestParam(required = false) List<String> currencies) throws IOException {
        return ResponseEntity.ok(metalService.getRates(base));
    }

}
