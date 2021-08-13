package com.falabella.challenge.controller;

import com.falabella.challenge.controller.dto.response.ProductResponse;
import com.falabella.challenge.controller.mapper.ProductMapper;
import com.falabella.challenge.model.Product;
import com.falabella.challenge.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductMapper productMapper;

    @Test
    void testing() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Product p = Product.builder().build();
        ProductResponse pr = ProductResponse.builder().build();

        when(productService.findBySku(1)).thenReturn(p);
        when(productMapper.mapResponse(p)).thenReturn(pr);

        String json = mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/product/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        ProductResponse pResponse = mapper.readValue(json, ProductResponse.class);


        assertEquals(pResponse, pr);


    }

    @Test
    void controllerError4xx() throws Exception {


        when(productService.findBySku(1)).thenThrow(new NoSuchElementException());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/product/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    @Test
    void controllerError5xx() throws Exception {


        when(productService.findBySku(1)).thenThrow(new RuntimeException());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/product/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is5xxServerError());


    }

}
