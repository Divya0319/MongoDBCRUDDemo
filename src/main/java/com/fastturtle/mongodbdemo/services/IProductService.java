package com.fastturtle.mongodbdemo.services;

import com.fastturtle.mongodbdemo.models.Product;

import java.util.List;

public interface IProductService {

    public Product getProductById(String id);

    public List<Product> getAllProducts();

    public Product createProduct(Product product);

    public Product deleteProduct(String id);
}
