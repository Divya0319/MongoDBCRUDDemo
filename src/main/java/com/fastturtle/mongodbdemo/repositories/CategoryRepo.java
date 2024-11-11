package com.fastturtle.mongodbdemo.repositories;

import com.fastturtle.mongodbdemo.models.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepo extends MongoRepository<Category, ObjectId> {
    Optional<Category> findByName(String name);
}
