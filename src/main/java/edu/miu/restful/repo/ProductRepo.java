package edu.miu.restful.repo;

import edu.miu.restful.entity.Product;

import java.util.List;

public interface ProductRepo {

    public List<Product> findAll();

    public Product getById(int id);

    public void save(Product p);

    public void delete(int id);
}
