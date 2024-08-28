package com.gft.test.inditex.domain.dao;

import com.gft.test.inditex.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceDao {
    Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate);
}
