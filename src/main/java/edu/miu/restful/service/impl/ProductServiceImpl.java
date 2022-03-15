package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Product;
import edu.miu.restful.repo.ProductRepo;
import edu.miu.restful.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // TODO add DTOs

    // TODO add two slides about DTOs
    // TODO ModelMapper

    private final ProductRepo productRepo;

    @Override
    public void save(Product p) {
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.getById(id);
    }
}
