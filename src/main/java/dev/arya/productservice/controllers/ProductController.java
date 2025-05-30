package dev.arya.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {

    @GetMapping
    public void getAllProduct(){

    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public String getProductById(@PathVariable("id") Long id){
        return "Here is product id : " + id;
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
