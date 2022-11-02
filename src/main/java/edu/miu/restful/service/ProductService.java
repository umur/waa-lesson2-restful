package edu.miu.restful.service;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.dto.ProductDetailDto;
import edu.miu.restful.entity.dto.ProductDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();

    ProductDto findById(int id);

    ProductDetailDto getReviewsByProductId(int id);

    void save(ProductDto p);

    void delete(int id);

    void update(int id, ProductDto p);

    Review getReviewByProductId(int pId, int reviewId);

    List<ProductDto>findAllPriceGreaterThan(int price);

}
