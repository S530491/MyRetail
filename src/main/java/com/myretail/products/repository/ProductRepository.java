package com.myretail.products.repository;

import com.myretail.products.model.MongoDBProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<MongoDBProduct, String> {


}
