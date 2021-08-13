package com.falabella.challenge.repository;

import com.falabella.challenge.model.Product;

import java.util.List;

public interface ProductRepository {

    Product findBySku(Integer id);
    void deleteBySku(Integer id);
    List<Product> findAll();
    Product update(Product productUpdated);
    Product save(Product product);

}
