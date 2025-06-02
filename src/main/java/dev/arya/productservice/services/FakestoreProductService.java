package dev.arya.productservice.services;

import dev.arya.productservice.dtos.FakeStoreProductDto;
import dev.arya.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("FakestoreProductService")
public class FakestoreProductService implements ProductService {


    private  RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl="https://fakestoreapi.com/products/{id}";

    public FakestoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    @Override
    public String getProductById(Long id){

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(getProductRequestUrl,FakeStoreProductDto.class,id);
        response.getStatusCode();
        return "Here is the Product ID :"+ id;

    }
}
