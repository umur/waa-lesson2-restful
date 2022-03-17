package edu.miu.restful.repo.impl;

import edu.miu.restful.entity.Product;
import edu.miu.restful.repo.ProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class ProductRepoImpl implements ProductRepo {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
    }

    public List<Product> findAll(){
        return products;
    }

    public void save(Product p) {
        var notExists = products
                .stream()
                .noneMatch(l -> l.getId() == p.getId());

        if (notExists) {
            products.add(p);
        }
    }

    public void delete(int id) {
        products
                .stream()
                .filter(l -> l.getId() == id)
                .forEach(l -> products.remove(l));
    }

    public Product getById(int id) {
        return products
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }



}
