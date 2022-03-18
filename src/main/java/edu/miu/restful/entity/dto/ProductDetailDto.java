package edu.miu.restful.entity.dto;

import edu.miu.restful.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class ProductDetailDto {

    private int id;
    private String name;
    private float price;

    private List<Review> reviews;
}
