package com.falabella.challenge.controller;

import com.falabella.challenge.controller.dto.request.ProductRequest;
import com.falabella.challenge.controller.dto.response.ProductResponse;
import com.falabella.challenge.controller.mapper.ProductMapper;
import com.falabella.challenge.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/{sku}")
    public ProductResponse getProductBySku(@PathVariable Integer sku) {
        return productMapper.mapResponse(productService.findBySku(sku));
    }

    @GetMapping("/")
    public List<ProductResponse> getProductAll() {
        return productService
                .getAll()
                .stream()
                .map(productMapper::mapResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse saveProduct(@RequestBody @Valid ProductRequest request) {
        return productMapper.mapResponse(productService.create(productMapper.mapRequest(request)));
    }

    @PutMapping("/update")
    public ProductResponse updateProduct(@RequestBody @Valid ProductRequest request) {
        return productMapper.mapResponse(productService.update(productMapper.mapRequest(request)));
    }

    @DeleteMapping("/{sku}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer sku) {
        productService.deleteBySku(sku);
    }


}
