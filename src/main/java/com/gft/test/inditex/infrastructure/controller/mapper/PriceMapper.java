package com.gft.test.inditex.infrastructure.controller.mapper;

import com.gft.test.inditex.domain.model.Price;
import com.gft.test.inditex.infrastructure.controller.response.PriceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceResponse toResponse(Price price);

}
