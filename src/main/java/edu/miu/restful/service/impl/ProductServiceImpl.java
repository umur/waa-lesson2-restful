package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.dto.ProductDetailDto;
import edu.miu.restful.entity.dto.ProductDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.ProductRepo;
import edu.miu.restful.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    // TODO add two slides about DTOs


    private final ProductRepo productRepo;


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Product,ProductDto> listMapperProductToDto;

    public List<ProductDto> findAll() {
        return (List<ProductDto>) listMapperProductToDto.mapList(productRepo.findAll(),new ProductDto());}


    public ProductDto getById(int id) {
        return modelMapper.map(productRepo.getById(id), ProductDto.class);
    }

    @Override
    public ProductDetailDto getReviewsByProductId(int id) {
        if(id == 0)
            return new ProductDetailDto();
        return modelMapper.map(productRepo.getById(id), ProductDetailDto.class);
    }

    @Override
    public void save(ProductDto p) {
        productRepo.save(modelMapper.map(p, Product.class));
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }

    @Override
    public void update(int id,  ProductDto p) {
        productRepo.update(id, modelMapper.map(p, Product.class));
    }

    @Override
    public Review getReviewByProductId(int pId, int reviewId){
        return productRepo.getReviewByProductId(pId, reviewId);
    }


    @Override
    public List<ProductDto>findAllPriceGreaterThan(int price){
        return (List<ProductDto>) listMapperProductToDto.mapList(productRepo.findAllPriceGreaterThan(price),new ProductDto());}


}
