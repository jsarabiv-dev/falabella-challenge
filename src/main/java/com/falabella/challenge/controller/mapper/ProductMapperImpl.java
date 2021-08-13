package com.falabella.challenge.controller.mapper;

import com.falabella.challenge.controller.dto.request.ProductRequest;
import com.falabella.challenge.controller.dto.response.ProductResponse;
import com.falabella.challenge.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product mapRequest(ProductRequest request) {
        return Product.builder()
                .sku(request.getSku())
                .name(request.getName())
                .brand(request.getBrand())
                .size(request.getSize())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .otherImageUrl(request.getOtherImageUrl())
                .build();
    }

    @Override
    public ProductResponse mapResponse(Product model) {
        return ProductResponse.builder()
                .sku(model.getSku())
                .name(model.getName())
                .brand(model.getBrand())
                .size(model.getSize())
                .price(model.getPrice())
                .imageUrl(model.getImageUrl())
                .otherImageUrl(model.getOtherImageUrl())
                .build();
    }
}
