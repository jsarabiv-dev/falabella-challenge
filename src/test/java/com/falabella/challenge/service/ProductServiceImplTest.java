package com.falabella.challenge.service;

import com.falabella.challenge.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    @BeforeEach
    void setUp() {
        Product p1 = new Product("","8406270", "500 Zapatilla Urbana Mujer", "New Balance", "37", 42990, "https://falabella.scene7.com/is/image/Falabella/8406270_1", Collections.singletonList(""));
        Product p2 = new Product("","881952283", "Bicicleta Baltoro Aro 29", "Jeep", "ST", 399990, "https://falabella.scene7.com/is/image/Falabella/881952283_1", Arrays.asList("https://falabella.scene7.com/is/image/Falabella/881952283_1", "https://falabella.scene7.com/is/image/Falabella/881952283_2"));
        Product p3 = new Product("","881898502", "Camisa Manga Corta Hombre", "Basement", "M", 24990, "https://falabella.scene7.com/is/image/Falabella/881898502_1", Collections.singletonList(""));


    }

    @Test
    void findBySku() {
    }

    @Test
    void deleteBySku() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void create() {
    }
}
