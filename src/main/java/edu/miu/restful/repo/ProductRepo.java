package edu.miu.restful.repo;

import edu.miu.restful.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepo {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
        var p = new Product();
        p.setId(1);
        p.setName("test product");
        p.setPrice(100);
        p.setDiscount(10);
        p.setCategory("test cat");
        products.add((p));
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
        // set deleted to true
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

    public List<Product> getAll(){
        return  products.stream()
                .filter(l->!l.isDeleted())
                .collect(Collectors.toList());
    }

}
