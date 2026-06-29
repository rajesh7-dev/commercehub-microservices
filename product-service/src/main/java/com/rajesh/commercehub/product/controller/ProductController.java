package com.rajesh.commercehub.product.controller;

import com.rajesh.commercehub.product.entity.Product;
import com.rajesh.commercehub.product.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return service.getProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return service.updateProduct(id , product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
         service.deleteProduct(id);
         return "Product Deleted";
    }




}
