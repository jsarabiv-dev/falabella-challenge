package com.falabella.challenge.repository;

import com.falabella.challenge.model.Product;
import com.falabella.challenge.repository.dto.ProductEntity;
import com.falabella.challenge.repository.mapper.ProductEntityMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryImplTest {

    ProductRepositoryImpl productRepository;

    private ProductSpringRepository productSpringRepository;

    Product product1;
    List<Product> products = new ArrayList<>();


    Optional<ProductEntity> optionalEmpty = Optional.empty();


    ProductEntity pEntity1 = ProductEntity.builder()
            .sku(8406270)
            .name("500 Zapatilla Urbana Mujer")
            .brand("New Balance")
            .size("37")
            .price(42990)
            .imageUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1")
            .otherImageUrl(Collections.singletonList(""))
            .build();

    Optional<ProductEntity> optionalProduct1 = Optional.of(pEntity1);


    List<ProductEntity> productsEntity = new ArrayList<>();

    @BeforeEach
    void setUp() {
        productSpringRepository = Mockito.mock(ProductSpringRepository.class);
        productRepository = new ProductRepositoryImpl(productSpringRepository, new ProductEntityMapperImpl());

        product1 = Product.builder()
                .sku(8406270)
                .name("500 Zapatilla Urbana Mujer")
                .brand("New Balance")
                .size("37")
                .price(42990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .otherImageUrl(Collections.singletonList(""))
                .build();
        products.add(product1);


        pEntity1 = ProductEntity.builder()
                .sku(8406270)
                .name("500 Zapatilla Urbana Mujer")
                .brand("New Balance")
                .size("37")
                .price(42990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .otherImageUrl(Collections.singletonList(""))
                .build();
        productsEntity.add(pEntity1);
        optionalEmpty.of(pEntity1);


    }

    @Test
    void findBySku() {
        when(productSpringRepository.findBySku(1)).thenReturn(optionalProduct1);
        assertEquals(this.product1, productRepository.findBySku(1));
    }

    @Test
    void findBySkuError() {
        when(productSpringRepository.findBySku(1)).thenReturn(optionalEmpty);
        NoSuchElementException excep = assertThrows(NoSuchElementException.class, () -> productRepository.findBySku(1));
        assertEquals("Product with sku " + 1 + " not found", excep.getMessage());

    }

    @Test
    void deleteBySku() {
        doNothing().when(productSpringRepository).deleteBySku(881952283);
        productRepository.deleteBySku(881952283);
    }


    @Test
    void findAll() {
        when(productSpringRepository.findAll()).thenReturn(productsEntity);
        assertEquals(this.products, productRepository.findAll());

    }

    @Test
    void update() {
        when(productSpringRepository.save(this.pEntity1)).thenReturn(this.pEntity1);
        when(productSpringRepository.findBySku(any(Integer.class))).thenReturn(optionalProduct1);
        assertEquals(this.product1, productRepository.update(this.product1));
    }

    @Test
    void save() {
        when(productSpringRepository.save(this.pEntity1)).thenReturn(this.pEntity1);
        assertEquals(this.product1, productRepository.save(this.product1));
    }
}
