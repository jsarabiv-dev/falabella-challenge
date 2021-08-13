package com.falabella.challenge.repository.mapper;

import com.falabella.challenge.model.Product;
import com.falabella.challenge.repository.dto.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapperImpl implements ProductEntityMapper {
    @Override
    public Product toModel(ProductEntity entity) {
        return Product.builder()
                .sku(entity.getSku())
                .name(entity.getName())
                .brand(entity.getBrand())
                .size(entity.getSize())
                .price(entity.getPrice())
                .imageUrl(entity.getImageUrl())
                .otherImageUrl(entity.getOtherImageUrl())
                .build();
    }

    @Override
    public ProductEntity toEntity(Product model) {
        return ProductEntity.builder()
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
