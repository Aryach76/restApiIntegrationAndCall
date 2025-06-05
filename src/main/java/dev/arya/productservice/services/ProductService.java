package dev.arya.productservice.services;

import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.exceptions.NotFoundException;
import dev.arya.productservice.models.Product;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long Id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto>getProducts();

    GenericProductDto deleteProductById(Long Id);



}
