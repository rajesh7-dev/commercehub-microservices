package com.rajesh.commercehub.product.service;

import com.rajesh.commercehub.product.entity.Product;

import java.util.List;

public interface ProductService {


    List<Product> getAllProducts();

    Product getProduct(Long id);

    Product addProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);



}
