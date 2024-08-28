package com.gft.test.inditex.infrastructure.repository.entity;

import com.gft.test.inditex.infrastructure.enums.Currency;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "prices")
@EqualsAndHashCode
@IdClass(PriceIdEntity.class)
public class PriceEntity {

    @Id
    private Long brandId;

    @Id
    private Long productId;

    @Id
    private LocalDateTime startDate;

    @Id
    private Long priceList;

    private LocalDateTime endDate;

    private Long priority;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Currency currency;

}
