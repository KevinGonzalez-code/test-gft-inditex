package com.gft.test.inditex.infrastructure.repository.mapper;

import com.gft.test.inditex.domain.model.Price;
import com.gft.test.inditex.infrastructure.repository.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Price toDomain(PriceEntity entity);

}
