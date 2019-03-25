package com.myretail.products;

import com.myretail.products.model.CurrentPrice;
import com.myretail.products.model.MongoDBProduct;
import com.myretail.products.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProductsApplication implements CommandLineRunner {

    //Registered the logger to check the output by print them
    Logger log = LoggerFactory.getLogger(ProductsApplication.class);

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //Delete all tables
        productRepository.deleteAll();

        //Inserting price value along with id to the nosql database
        MongoDBProduct product = new MongoDBProduct("13860428", new CurrentPrice("10", "USD"));
        MongoDBProduct product1 = new MongoDBProduct("50513417", new CurrentPrice("100", "USD"));
        MongoDBProduct product2 = new MongoDBProduct("15643793", new CurrentPrice("1000", "USD"));
        MongoDBProduct product3 = new MongoDBProduct("16752456", new CurrentPrice("1000", "USD"));

        //saving all users to mongo db
        productRepository.save(product);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //fetching all users from mongo db
        productRepository.findAll().forEach(x -> log.info("-" + x));


    }
}
