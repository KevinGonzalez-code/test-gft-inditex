package com.gft.test.inditex.domain.service;

import com.gft.test.inditex.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceService {

    Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate);

}
