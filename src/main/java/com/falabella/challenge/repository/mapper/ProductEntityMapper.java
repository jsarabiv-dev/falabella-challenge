package com.falabella.challenge.repository.mapper;

import com.falabella.challenge.model.Product;
import com.falabella.challenge.repository.dto.ProductEntity;

public interface ProductEntityMapper {

    Product toModel(ProductEntity entity);

    ProductEntity toEntity(Product model);


}
