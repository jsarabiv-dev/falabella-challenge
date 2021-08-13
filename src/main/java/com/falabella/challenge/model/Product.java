package com.falabella.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private String _id;
    private String sku;
    private String name;
    private String brand;
    private String size;
    private Integer price;
    private String imageUrl;
    private List<String> otherImageUrl;


}
