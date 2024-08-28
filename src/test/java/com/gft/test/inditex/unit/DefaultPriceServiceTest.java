package com.gft.test.inditex.unit;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gft.test.inditex.application.service.DefaultPriceService;
import com.gft.test.inditex.domain.dao.PriceDao;
import com.gft.test.inditex.domain.model.Price;

@ExtendWith(MockitoExtension.class)
public class DefaultPriceServiceTest {
    @Mock
    private PriceDao priceDao;

    @InjectMocks
    private DefaultPriceService defaultPriceService;

    @Test
    public void getPriceFound() {

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Price expectedPrice = new Price();
        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPrice(BigDecimal.valueOf(35.50));
        when(priceDao.getPrice(35455L, 1L, applicationDate)).thenReturn(expectedPrice);

        Price actualPrice = defaultPriceService.getPrice(35455L, 1L, applicationDate);

        assertEquals(expectedPrice.getBrandId(), actualPrice.getBrandId());
        assertEquals(expectedPrice.getProductId(), actualPrice.getProductId());
        assertEquals(expectedPrice.getPrice(), actualPrice.getPrice());
    }

    @Test
    public void getPriceNotFound() {

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        when(priceDao.getPrice(35455L, 1L, applicationDate)).thenReturn(null);

        Price actualPrice = defaultPriceService.getPrice(35455L, 1L, applicationDate);

        assertNull(actualPrice);
    }

    @Test
    public void getPriceWithDifferentBrand() {

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Price expectedPrice = new Price();

        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPrice(BigDecimal.valueOf(35.50));

        when(priceDao.getPrice(any(Long.class), any(Long.class), any(LocalDateTime.class)))
                .thenReturn(expectedPrice);

        Price actualPrice = defaultPriceService.getPrice(35455L, 1L, applicationDate);

        assertNotNull(actualPrice);
        assertEquals(expectedPrice.getPrice(), actualPrice.getPrice());
    }

    @Test
    public void getPriceWithDifferentDate() {
        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);
        Price expectedPrice = new Price();

        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPrice(BigDecimal.valueOf(30.50));

        when(priceDao.getPrice(35455L, 1L, applicationDate)).thenReturn(expectedPrice);

        Price actualPrice = defaultPriceService.getPrice(35455L, 1L, applicationDate);

        assertNotNull(actualPrice);
        assertEquals(expectedPrice.getPrice(), actualPrice.getPrice());
    }

    @Test
    public void getPriceWithDifferentProduct() {

        LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
        Price expectedPrice = new Price();

        expectedPrice.setBrandId(1L);
        expectedPrice.setProductId(35455L);
        expectedPrice.setPrice(BigDecimal.valueOf(25.45));

        when(priceDao.getPrice(any(Long.class), any(Long.class), any(LocalDateTime.class)))
                .thenReturn(expectedPrice);

        Price actualPrice = defaultPriceService.getPrice(35455L, 2L, applicationDate);

        assertNotNull(actualPrice);
        assertEquals(expectedPrice.getPrice(), actualPrice.getPrice());
    }
}
