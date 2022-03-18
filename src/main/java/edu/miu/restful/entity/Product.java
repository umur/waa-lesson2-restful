package edu.miu.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private float price;

    private List<Review> reviews;
}
