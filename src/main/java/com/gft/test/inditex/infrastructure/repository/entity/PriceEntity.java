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

    /*
     * He decidido hacer una PK compuesta por varias columnas para asegurar la
     * unicidad de cada registro y evitar duplicados
     * basándome en esta PK compuesta.
     * 
     * BRAND_ID: Identifica la marca a la pertenece el precio
     * PRICE_LIST: Identifica de manera única la tarifa
     * PRODUCT_ID: Identifica un producto en especifico
     * START_DATE: Define el comienzo del rango de fechas durante el precio se
     * aplica
     * 
     * De esta forma se garantiza que no haya dos registros con la misma combinación
     * de marca
     * , tarifa, producto y fecha de inicio y evitaríamos la duplicación de
     * registros
     */

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
