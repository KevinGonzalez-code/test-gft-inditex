package com.gft.test.inditex.infrastructure.dao;

import com.gft.test.inditex.domain.dao.PriceDao;
import com.gft.test.inditex.domain.exception.PriceNotFoundException;
import com.gft.test.inditex.domain.model.Price;
import com.gft.test.inditex.infrastructure.repository.jpa.JpaPriceRepository;
import com.gft.test.inditex.infrastructure.repository.mapper.PriceEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Component
public class JpaPriceDao implements PriceDao {

    @Autowired
    private JpaPriceRepository priceJpaRepository;

    @Autowired
    private PriceEntityMapper priceEntityMapper;

    @Override
    public Price getPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        return priceJpaRepository.findByPrice(productId, brandId, applicationDate)
                .map(priceEntityMapper::toDomain)
                .orElseThrow(() -> new PriceNotFoundException(productId, brandId, applicationDate));
    }
}
