package edu.miu.restful.service.impl;

import edu.miu.restful.dto.ProductDto;
import edu.miu.restful.entity.Product;
import edu.miu.restful.repo.ProductRepo;
import edu.miu.restful.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // TODO add DTOs

    // TODO add two slides about DTOs
    // TODO ModelMapper

    private final ProductRepo productRepo;

    @Override
    public void save(ProductDto dto) {
        Product p = new Product();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        //....
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }

    @Override
    public List<ProductDto> getAll() {
        var entityList=  productRepo.getAll();

        var result = new ArrayList<ProductDto>();
        entityList.forEach(l->{
            //convert
            ProductDto dto = new ProductDto();
            dto.setId(l.getId());
            //...
            result.add(dto);
        });

        return result;
    }

    @Override
    public Product getById(int id) {
        return productRepo.getById(id);
    }
}
