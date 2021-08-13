package com.falabella.challenge.controller;

import com.falabella.challenge.controller.dto.request.ProductRequest;
import com.falabella.challenge.controller.dto.response.ProductResponse;
import com.falabella.challenge.controller.mapper.ProductMapperImpl;
import com.falabella.challenge.model.Product;
import com.falabella.challenge.service.ProductService;
import com.falabella.challenge.service.ProductServiceImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    ProductRequest productRequest1;

    ProductResponse productResponse1;
    ProductResponse productResponse2;
    List<ProductResponse> productResponses = new ArrayList<>();

    Product p1;
    Product p2;
    List<Product> products = new ArrayList<>();

    @BeforeEach
    void setUp() {

        productController = new ProductController(productService, new ProductMapperImpl());

        productRequest1 = ProductRequest.builder()
                .sku(8406270)
                .name("500 Zapatilla Urbana Mujer")
                .brand("New Balance")
                .size("37")
                .price(42990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .otherImageUrl(Collections.singletonList(""))
                .build();

        productResponse1 = ProductResponse.builder()
                .sku(8406270)
                .name("500 Zapatilla Urbana Mujer")
                .brand("New Balance")
                .size("37")
                .price(42990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .otherImageUrl(Collections.singletonList(""))
                .build();

        productResponse2 = ProductResponse.builder()
                .sku(881952283)
                .name("Bicicleta Baltoro Aro 29")
                .brand("Jeep")
                .size("ST")
                .price(399990)
                .imageUrl("https://falabella.scene7.com/is/image/Falabella/881952283_1")
                .otherImageUrl(Arrays.asList("https://falabella.scene7.com/is/image/Falabella/881952283_1", "https://falabella.scene7.com/is/image/Falabella/881952283_2"))
                .build();

        productResponses.add(productResponse1);
        productResponses.add(productResponse2);

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

        products.add(p1);
        products.add(p2);
    }

    @Test
    void getProductBySku() {
        when(productService.findBySku(any(Integer.class))).thenReturn(this.p1);
        assertEquals(productResponse1, productController.getProductBySku(8406270));
    }

    @Test
    void getProductAll() {
        when(productService.getAll()).thenReturn(this.products);
        assertEquals(productResponses, productController.getProductAll());
    }

    @Test
    void saveProduct() {
        when(productService.create(this.p1)).thenReturn(this.p1);
        assertEquals(productResponse1, productController.saveProduct(this.productRequest1));
    }


    @Test
    void updateProduct() {
        when(productService.update(this.p1)).thenReturn(this.p1);
        assertEquals(productResponse1, productController.updateProduct(this.productRequest1));
    }

    @Test
    void deleteProduct() {
        doNothing().when(productService).deleteBySku(881952283);
        productController.deleteProduct(881952283);
    }
}
