package edu.miu.restful.entity;

import lombok.Data;

@Data
public class Review {

    private int id;
    private String comment;
    private int numberOfStars;

}
