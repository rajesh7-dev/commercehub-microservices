package com.rajesh.commercehub.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/test")
    public String Test(){
        return "Product service Working";
    }

}
