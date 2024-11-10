package com.fastturtle.mongodbdemo.controllers;

import com.fastturtle.mongodbdemo.models.Product;
import com.fastturtle.mongodbdemo.repositories.ProductRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product) {
        productRepo.save(product);

        return "Product added";
    }

    @GetMapping("/view")
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepo.deleteById(id);
        return "Product deleted";
    }

}
