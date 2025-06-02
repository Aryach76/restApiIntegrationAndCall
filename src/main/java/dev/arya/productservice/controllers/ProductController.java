package dev.arya.productservice.controllers;

import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {


    @Autowired
    private ProductService productService;

    public ProductController(@Qualifier("FakestoreProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public void getAllProduct(){

    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }

    @PostMapping()
    public void createProduct(){

    }

    @PutMapping("{id}")
    public void updateProductById(){

    }


}
