package com.gft.test.inditex.infrastructure.controller.response;

import com.gft.test.inditex.infrastructure.enums.Currency;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PriceResponse {
    private Long brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    private BigDecimal price;
    private Long priceList;
    private Currency currency;
}
