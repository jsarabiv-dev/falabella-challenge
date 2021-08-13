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
    public Product findBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    @Override
    public void deleteBySku(String sku) {
        productRepository.deleteBySku(sku);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product updateProduct) {
        Product product = findBySku(updateProduct.getSku());
        product.setPrice(updateProduct.getPrice());
        return productRepository.update(product);
    }


    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
