package edu.miu.restful.service;

import edu.miu.restful.entity.Product;

public interface ProductService {

    void save(Product p);

    void delete(int id);

    Product getById(int id);
}
