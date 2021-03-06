package com.falabella.challenge.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Integer sku;
    private String name;
    private String brand;
    private String size;
    private Integer price;
    private String imageUrl;
    private List<String> otherImageUrl;


}
