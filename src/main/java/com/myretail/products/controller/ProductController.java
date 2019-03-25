package com.myretail.products.controller;

import com.myretail.products.model.CurrentPrice;
import com.myretail.products.model.MongoDBProduct;
import com.myretail.products.model.Product;
import com.myretail.products.repository.ProductRepository;
import com.myretail.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    //by hitting the base url, info of the application will be displayed
    @GetMapping("/")
    public void getHome(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/actuator/info");
    }

    // This method will displays the list of products
    @GetMapping("/products")
    public List<Product> getProducts() throws IOException {

        List<Product> products = new ArrayList<>();
        //retrieving all the products using productRepository find all method.
        productRepository.findAll().forEach(x -> {
            try {
                //It will return the products having name
                if (productService.getProductNameById(x.getId()) != null) {
                    products.add(new Product(x.getId(), productService.getProductNameById(x.getId()), x.getCurrentPrice()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return products;
    }

    //Return the product belongs to the given id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id) throws IOException {
        if (productService.getProductNameById(id) != null) {
            return new Product(id, productService.getProductNameById(id), productRepository.findById(id).get().getCurrentPrice());
        } else return new Product();
    }
    //updates price of the product belongs to the given id
    @PutMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable String id, @RequestParam String price, HttpServletResponse httpServletResponse) throws IOException {
       if(!price.matches("[0-9/.]+")){
return new ResponseEntity<>("Invalid Price, please enter valid price.", HttpStatus.BAD_REQUEST);
        }
        if (productService.getProductNameById(id) != null) {
            productRepository.save(new MongoDBProduct(id, new CurrentPrice(price, productRepository.findById(id).get().getCurrentPrice().getCurrency_code())));
            //Once the price got updated redirecting the page to list of products page
            httpServletResponse.sendRedirect("/products");
            //responseEntity = new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Id, please enter valid Id.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.OK);


    }
}

