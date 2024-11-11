package com.fastturtle.mongodbdemo.repositories;

import com.fastturtle.mongodbdemo.models.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepo extends MongoRepository<Product, ObjectId> {

    void deleteByProductId(String productId);

    Optional<Product> findByProductId(String productId);
}
