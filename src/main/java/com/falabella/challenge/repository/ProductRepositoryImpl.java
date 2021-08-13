package com.falabella.challenge.repository;

import com.falabella.challenge.model.Product;
import com.falabella.challenge.repository.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductSpringRepository productSpringRepository;
    private final ProductEntityMapper productEntityMapper;


    @Override
    public Product findBySku(String sku) {

        return productSpringRepository
                .findBySku(sku)
                .map(productEntityMapper::toModel)
                .orElseThrow(() -> new NoSuchElementException("Product with sku " + sku + " not found"));

    }

    @Override
    public void deleteBySku(String sku) {
        productSpringRepository.deleteBySku(sku);
    }

    @Override
    public List<Product> findAll() {
        return productSpringRepository
                .findAll()
                .stream()
                .map(productEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Product update(Product productUpdated) {
        return productEntityMapper.toModel(productSpringRepository.save(productEntityMapper.toEntity(productUpdated)));
    }

    @Override
    public Product save(Product product) {
        return productEntityMapper.toModel(productSpringRepository.save(productEntityMapper.toEntity(product)));
    }
}
