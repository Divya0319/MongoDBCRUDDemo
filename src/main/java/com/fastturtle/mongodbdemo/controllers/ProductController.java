package com.fastturtle.mongodbdemo.controllers;

import com.fastturtle.mongodbdemo.ProductDto;
import com.fastturtle.mongodbdemo.models.Product;
import com.fastturtle.mongodbdemo.repositories.ProductRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDto productDto) {
        productRepo.save(from(productDto));

        return "Product added";
    }

    @GetMapping("/view")
    public List<ProductDto> getProducts() {
        return productRepo.findAll().stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String productId) {
        productRepo.deleteByProductId(productId);
        return "Product deleted";
    }

    public Product from(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getId());
        product.setName(productDto.getName());
        product.setDesc(productDto.getDesc());

        return product;
    }

    public ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setDesc(product.getDesc());

        return productDto;
    }

}
