package edu.miu.restful.controller;

import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.dto.ProductDetailDto;
import edu.miu.restful.entity.dto.ProductDto;
import edu.miu.restful.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<ProductDto> getAll() {
        return productService.findAll();
    }
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<ProductDto> getAll(@RequestParam(value = "filter" ,required = false) Integer price) {
//        return price==null?productService.findAll():productService.findAllPriceGreaterThan(price);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody ProductDto p) {
        productService.save(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id) {
        var product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int productId, @RequestBody ProductDto p) {
        productService.update(productId,p);
    }

    @GetMapping("/{id}/reviews")
    public ProductDetailDto getReviewsByProductId(@PathVariable int id) {
        return productService.getReviewsByProductId(id);
    }

    @GetMapping("/{id}/reviews/{reviewId}") // WITHOUT DTO
    public Review getReviewByProductId(@PathVariable("id") int pId, @PathVariable("reviewId") int reviewId) {
        return productService.getReviewByProductId(pId, reviewId);
    }


    // FOR DEMO PURPOSES
    @GetMapping("/{productId}/{reviewId}")
    public Review mapDemo(@PathVariable Map<String, Integer> pathVariables) {
        int pid = pathVariables.get("productId");
        int reviewId = pathVariables.get("reviewId");
        return null;
    }

    // FOR DEMO PURPOSES
    @GetMapping(value =
            {
                    "/handlingMultipleEndpoints",
                    "/handlingMultipleEndpoints/{id}"
            })
    public String multipleEndpointsDemo(@PathVariable(required = false) String id) {
        if (id != null) {
            return "ID: " + id;
        } else {
            return "ID missing";
        }
    }

    // FOR DEMO PURPOSES
    @GetMapping("/h/{id}")
    public EntityModel<ProductDto> getByIdH(@PathVariable int id) {

        ProductDto product = productService.getById(id);
        EntityModel<ProductDto> resource = EntityModel.of(product);
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
        resource.add(linkTo.withRel("all-products"));

        return resource;
    }



}
