package dev.arya.productservice.controllers;

import dev.arya.productservice.dtos.ExceptionDto;
import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.exceptions.NotFoundException;
import dev.arya.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    public ProductController(@Qualifier("FakestoreProductService") ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProduct(){
        return productService.getProducts();
    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException{
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){
        ResponseEntity<GenericProductDto> response=new ResponseEntity<>(
                productService.deleteProductById(id), HttpStatus.NOT_FOUND
        );
        return response;
    }

    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductById(){

    }




}
