package com.gft.test.inditex.domain.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(Long productId, Long brandId, LocalDateTime applicationDate) {
        super(String.format("No price found for the product with ID %d and brand with ID %d on the date %s", productId,
                brandId, applicationDate));
    }
}
