package edu.miu.restful.service;

import edu.miu.restful.dto.ProductDto;
import edu.miu.restful.entity.Product;

import java.util.List;

public interface ProductService {

    void save(ProductDto p);

    void delete(int id);

    List<ProductDto> getAll();

    Product getById(int id);
}
