package com.falabella.challenge.repository;

import com.falabella.challenge.model.Product;
import com.falabella.challenge.repository.dto.ProductEntity;
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
    public Product findBySku(Integer sku) {

        return productSpringRepository
                .findBySku(sku)
                .map(productEntityMapper::toModel)
                .orElseThrow(() -> new NoSuchElementException("Product with sku " + sku + " not found"));

    }

    @Override
    public void deleteBySku(Integer sku) {
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

        ProductEntity p = productEntityMapper.toEntity(productUpdated);

        return productSpringRepository.findBySku(productUpdated.getSku()).map(
                productEntity -> setId(p, productEntity)
        ).map(productEntity -> productSpringRepository.save(productEntity)).map(productEntity -> productEntityMapper.toModel(productEntity))
                .orElseThrow( () -> new NoSuchElementException("Product with sku " + productUpdated.getSku() + " not found"));


    }

    private ProductEntity setId(ProductEntity p, ProductEntity productEntity) {
        return p.toBuilder()._id(productEntity.get_id()).build();
    }

    @Override
    public Product save(Product product) {
        return productEntityMapper.toModel(productSpringRepository.save(productEntityMapper.toEntity(product)));
    }
}
