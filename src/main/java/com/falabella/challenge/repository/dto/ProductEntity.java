package com.falabella.challenge.repository.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Value
@Builder(toBuilder = true)
@Document(collection = "products")
public class ProductEntity {

    @Id
    private final String _id;

    @Indexed(unique = true)
    private Integer sku;

    private String name;
    private String brand;
    private String size;
    private Integer price;
    private String imageUrl;
    private List<String> otherImageUrl;


}
