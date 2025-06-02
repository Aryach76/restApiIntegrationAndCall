package dev.arya.productservice.services;

import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.models.Product;

public interface ProductService {

    GenericProductDto getProductById(Long Id);

}
