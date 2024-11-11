package com.fastturtle.mongodbdemo.controllers;

import com.fastturtle.mongodbdemo.dtos.CategoryDto;
import com.fastturtle.mongodbdemo.dtos.ProductDto;
import com.fastturtle.mongodbdemo.models.Category;
import com.fastturtle.mongodbdemo.models.Product;
import com.fastturtle.mongodbdemo.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {

        Product product = from(productDto);

        Product result = productService.createProduct(product);

        return from(result);
    }

    @GetMapping("/view")
    public List<ProductDto> getProducts() {
        List<Product> products = productService.getAllProducts();
        if(!products.isEmpty()) {
            List<ProductDto> result = products.stream().map(this::from).toList();
            return result;
        }

        return null;
    }

    @GetMapping("/view/{id}")
    public ProductDto getProduct(@PathVariable("id") String productId) {
        Product product = productService.getProductById(productId);
        return from(product);
    }

    @DeleteMapping("/delete/{id}")
    public ProductDto deleteProduct(@PathVariable("id") String productId) {
        Product deleted = productService.deleteProduct(productId);
        return from(deleted);
    }

    public Product from(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getId());
        product.setName(productDto.getName());
        product.setDesc(productDto.getDesc());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setCategoryId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            category.setDesc(productDto.getCategory().getDesc());
            product.setCategory(category);
        }

        return product;
    }

    public ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setDesc(product.getDesc());

        if (product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(product.getCategory().getCategoryId());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setDesc(product.getCategory().getDesc());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }

}
