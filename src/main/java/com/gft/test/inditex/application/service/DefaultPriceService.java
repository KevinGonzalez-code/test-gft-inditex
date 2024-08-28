package com.gft.test.inditex.application.service;

import com.gft.test.inditex.domain.dao.PriceDao;
import com.gft.test.inditex.domain.model.Price;
import com.gft.test.inditex.domain.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DefaultPriceService implements PriceService {

    @Autowired
    private PriceDao priceDao;

    @Override
    public Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        return priceDao.getPrice(productId, brandId, applicationDate);
    }
}
