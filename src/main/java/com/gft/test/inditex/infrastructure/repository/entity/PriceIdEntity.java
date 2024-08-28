package com.gft.test.inditex.infrastructure.repository.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class PriceIdEntity {
    private Long brandId;
    private Long productId;
    private LocalDateTime startDate;
    private Long priceList;
}
