package com.fastturtle.mongodbdemo.services;

import com.fastturtle.mongodbdemo.models.Category;
import com.fastturtle.mongodbdemo.models.Product;
import com.fastturtle.mongodbdemo.repositories.CategoryRepo;
import com.fastturtle.mongodbdemo.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepo.findByProductId(id);

        if(product.isPresent()) {
            return product.get();
        }

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();

        if(!products.isEmpty()) {
            return products;
        }

        return null;
    }

    @Override
    public Product createProduct(Product product) {

        Optional<Category> categoryOptional = categoryRepo.findByName(product.getCategory().getName());

        if(categoryOptional.isPresent()) {
            product.setCategory(categoryOptional.get());
        } else {
            Category newCategory = product.getCategory();
            categoryRepo.save(newCategory);
            product.setCategory(newCategory);
        }
        productRepo.save(product);

        return product;
    }

    @Override
    public Product deleteProduct(Long id) {
        Optional<Product> product = productRepo.findByProductId(id);
        if(product.isPresent()) {
            productRepo.deleteByProductId(id);
        } else {
            return null;
        }

        return product.get();
    }
}
