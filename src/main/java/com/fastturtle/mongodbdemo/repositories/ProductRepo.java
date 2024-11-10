package com.fastturtle.mongodbdemo.repositories;

import com.fastturtle.mongodbdemo.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, Integer> {
}
