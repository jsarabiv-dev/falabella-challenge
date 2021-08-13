package com.falabella.challenge.controller.mapper;

import com.falabella.challenge.controller.dto.request.ProductRequest;
import com.falabella.challenge.controller.dto.response.ProductResponse;
import com.falabella.challenge.model.Product;

public interface ProductMapper {

    Product mapRequest(ProductRequest request);

    ProductResponse mapResponse(Product model);


}
