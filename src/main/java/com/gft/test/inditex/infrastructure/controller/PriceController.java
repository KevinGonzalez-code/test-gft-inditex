package com.gft.test.inditex.infrastructure.controller;

import com.gft.test.inditex.application.exception.InvalidParameterException;
import com.gft.test.inditex.domain.exception.PriceNotFoundException;
import com.gft.test.inditex.domain.service.PriceService;
import com.gft.test.inditex.infrastructure.controller.mapper.PriceMapper;
import com.gft.test.inditex.infrastructure.controller.response.PriceResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Tag(name = "Price", description = "This API allows you to consult prices")
@RequestMapping("/api/v1/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @Autowired
    private PriceMapper priceMapper;

    @Operation(summary = "Obtains the price of a product", description = "This method returns the price of a product filtered by brandId, productId and date of application.")
    @GetMapping
    public ResponseEntity<PriceResponse> getPrices(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        if (productId == null || applicationDate == null || brandId == null) {
            throw new InvalidParameterException(
                    "There are null or non-existent parameters, all parameters are mandatory");
        }

        try {
            return ResponseEntity.ok(
                    priceMapper.toResponse(priceService.getPrice(
                            productId,
                            brandId,
                            applicationDate)));
        } catch (PriceNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }

    }
}
