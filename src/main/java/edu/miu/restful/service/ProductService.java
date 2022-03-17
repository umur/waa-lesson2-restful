package edu.miu.restful.service;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.dto.ProductDto;

import java.util.List;

public interface ProductService {

    public List<ProductDto> findAll();

    ProductDto getById(int id);

    void save(ProductDto p);

    void delete(int id);
}
