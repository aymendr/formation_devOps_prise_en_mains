package com.example.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/messagestock/{name}")
    public String getNotification(@PathVariable("name") String name){
        return "Le produit : " + name +" a été rajouté au stock";
    }

    @GetMapping(path = "/produit/{id}")
    public String getPrice(@PathVariable("id") Integer id){
        ResponseEntity<String> produit = restTemplate.exchange("http://localhost:8081/productservice/"+id, HttpMethod.GET,null,String.class);
        return produit.getBody();
    }
}
