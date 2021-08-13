package com.falabella.challenge.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    @NotNull
    @Range(min=1000000, max=99999999)
    private Integer sku;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    @NotNull
    @Size(min=3, max=50)
    private String brand;

    private String size;

    @NotNull
    @Range(min=1, max=99999999)
    private Integer price;

    @NotNull
    private String imageUrl;

    private List<String> otherImageUrl;


}
