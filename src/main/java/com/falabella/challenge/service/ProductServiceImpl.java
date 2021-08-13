package com.falabella.challenge.service;

import com.falabella.challenge.model.Product;
import com.falabella.challenge.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findBySku(Integer sku) {
        return productRepository.findBySku(sku);
    }

    @Override
    public void deleteBySku(Integer sku) {
        productRepository.deleteBySku(sku);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product updateProduct) {
        return productRepository.update(updateProduct);
    }


    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
