package edu.miu.restful.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductDto {


    private int id;
    private String name;
    private float price;

    private String category;
    private int discount;
    private int starCount;


}
