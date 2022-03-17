package edu.miu.restful.entity.dto;

import edu.miu.restful.entity.Review;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private int id;
    private String name;
    private float price;

}
