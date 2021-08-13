package com.falabella.challenge.service;

import com.falabella.challenge.model.Product;

import java.util.List;

public interface ProductService {

    Product findBySku(String sku);

    void deleteBySku(String sku);

    List<Product> getAll();

    Product update(Product product);

    Product create(Product product);



}
