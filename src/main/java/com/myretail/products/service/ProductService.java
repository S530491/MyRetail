package com.myretail.products.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class ProductService {
    String title;

    Logger log = LoggerFactory.getLogger(ProductService.class);
    //Below method returns the title of the product from the given url using the given id
    public String getProductNameById(String id) throws IOException {
        String URL = "https://redsky.target.com/v2/pdp/tcin/" + id + "?excludes=price,promotion,rating_and_review_reviews,bulk_ship,question_answer_statistics,deep_red_labels,rating_and_review_statistics,available_to_promise_network";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        try {
            responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, String.class);
        } catch (HttpClientErrorException ex) {
            log.error(ex.getMessage());
        }

        log.info("Id: " + id);
        log.info("Response code: " + responseEntity.getStatusCode());
        log.info("Response:\n\n" + responseEntity.getBody());

        ObjectMapper objectMapper = new ObjectMapper();
        if (responseEntity.getBody() != null) {
            Map<String, Map> map = objectMapper.readValue(responseEntity.getBody(), Map.class);
            Stream.of(map).forEach(System.out::println);
            Map<String, Map> productMap = map.get("product");
            Map<String, Map> itemMap = productMap.get("item");
            Map<String, String> productDescriptionMap = itemMap.get("product_description");
            title = productDescriptionMap.get("title");
        } else return null;


        return title;
    }
}
