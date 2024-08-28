package com.gft.test.inditex.infrastructure.controller.request;

import com.gft.test.inditex.infrastructure.enums.Currency;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class PriceRequest {

    private ZonedDateTime startDate;
    private Long productId;
    private Currency currency;

}
