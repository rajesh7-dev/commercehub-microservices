package com.rajesh.commercehub.order.dto;

import lombok.Data;

@Data
public class Product {


    private Long id;
    private String name;
    private String category;
    private int quantity;
    private double price;


}
