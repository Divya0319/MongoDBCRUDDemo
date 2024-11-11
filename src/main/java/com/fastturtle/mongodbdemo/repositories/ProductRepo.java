package com.fastturtle.mongodbdemo.repositories;

import com.fastturtle.mongodbdemo.models.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, ObjectId> {

    void deleteByProductId(String productId);
}
