package com.falabella.challenge.service;

import com.falabella.challenge.model.Product;
import com.falabella.challenge.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {


    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    Product p1;
    Product p2;
    Product p3;
    List<Product> products = new ArrayList<>();

    @BeforeEach
    void setUp() {
         p1 =  Product.builder()
                .sku(8406270)
                .name("500 Zapatilla Urbana Mujer")
                .brand("New Balance")
                .size("37")
                .price(42990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .otherImageUrl(Collections.singletonList(""))
                .build();

         p2 =  Product.builder()
                .sku(881952283)
                .name("Bicicleta Baltoro Aro 29")
                .brand("Jeep")
                .size("ST")
                .price(399990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/881952283_1")
                .otherImageUrl(Arrays.asList("https://falabella.scene7.com/is/image/Falabella/881952283_1", "https://falabella.scene7.com/is/image/Falabella/881952283_2"))
                .build();

         p3 =  Product.builder()
                .sku(881898502)
                .name("Camisa Manga Corta Hombre")
                .brand("Basement")
                .size("M")
                .price(24990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/881898502_1")
                .otherImageUrl(Collections.singletonList(""))
                .build();

        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    @Test
    void findBySku() {
        when(productRepository.findBySku(any(Integer.class))).thenReturn(this.p1);
        assertEquals(Product.class, productService.findBySku(8406270).getClass());

        when(productRepository.findBySku((8406270))).thenReturn((this.p1));
        assertEquals(this.p1, productService.findBySku(8406270));
    }

    @Test
    void deleteBySku() {
        doNothing().when(productRepository).deleteBySku(881952283);
        productService.deleteBySku(881952283);
    }

    @Test
    void getAll() {
        when(productRepository.findAll()).thenReturn(this.products);
        assertEquals(this.products, productService.getAll());
        assertEquals(ArrayList.class, productService.getAll().getClass());
    }

    @Test
    void update() {
        when(productRepository.update((this.p1))).thenReturn((this.p1));
        assertEquals(this.p1, productService.update(this.p1));
    }

    @Test
    void create() {
        when(productRepository.save((this.p1))).thenReturn((this.p1));
        assertEquals(this.p1, productService.create(this.p1));
    }
}
