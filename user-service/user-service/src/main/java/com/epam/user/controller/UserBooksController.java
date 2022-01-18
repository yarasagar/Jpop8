package com.epam.user.controller;

import com.epam.user.config.CloudConfig;
import com.epam.user.entity.Books;
import com.epam.user.entity.Limits;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserBooksController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CloudConfig config;

    @Value("${minValue}")
    private int minValue;

    @Value("${maxValue}")
    private int maxValue;

    @GetMapping("/userBooks")
    public List<Books> getUserBooks() {
        //for single book
/*        ResponseEntity<Books> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:9002/api/books/1", Books.class);*/
        //for list conversion, but it is not working
/*        ResponseEntity<List<Books>> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:9002/api/books",
                        new TypeReference<List<Books>>(){});*/
        //for array of books
        ResponseEntity<Books[]> responseEntity = restTemplate
                .exchange("http://BOOK-SERVICE/api/books/", HttpMethod.GET,
                        null, Books[].class);
        return Arrays.asList(responseEntity.getBody());
    }

    @GetMapping("/limits")
    public Limits getLimits() {
        return new Limits(minValue, maxValue);
    }
}