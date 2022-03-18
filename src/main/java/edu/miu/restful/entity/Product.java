package edu.miu.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private float price;

    private String category;
    private int discount;
    private int starCount;

    private boolean deleted;

    private LocalDateTime createdAt;
     // ....

    private List<Review> reviews;
}
