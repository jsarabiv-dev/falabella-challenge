package com.falabella.challenge.repository;

import com.falabella.challenge.repository.dto.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductSpringRepository extends MongoRepository<ProductEntity, String> {

    Optional<ProductEntity> findBySku(Integer sku);

    void deleteBySku(Integer sku);



}
