package com.example.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/productservice") // This means URL's start with /product (after Application path)
public class ProductController {
    @Autowired // This means to get the bean called productRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ProductRepository productRepository;


    @Autowired
    private RestTemplate restTemplate;




    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewProduct (@RequestParam(name = "name") String name, @RequestParam(name = "price") Long prix) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        System.out.println(name);



        Product n = new Product();
        n.setName(name);
        n.setPrice(prix);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8082/notification/messagestock/"+n.getName(),String.class);
        String notification = responseEntity.getBody();



        productRepository.save(n);
        //System.out.println(notification);

        return notification;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Product> getAllProducts() {
        // This returns a JSON or XML with the products
        return productRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Optional<Product> getProductById(@PathVariable("id") int id) {
        // This returns a JSON or XML with the products
        return productRepository.findById(id);
    }

}