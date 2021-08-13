package com.falabella.challenge.model;

import lombok.*;

import java.util.List;

@Value
@AllArgsConstructor
@Builder
public class Product {

    private Integer sku;
    private String name;
    private String brand;
    private String size;
    private Integer price;
    private String imageUrl;
    private List<String> otherImageUrl;


}
