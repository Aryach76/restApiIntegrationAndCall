package dev.arya.productservice.services;

import dev.arya.productservice.dtos.FakeStoreProductDto;
import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;
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
    public GenericProductDto getProductById(Long id){

        RestTemplate restTemplate=restTemplateBuilder.build();
        System.out.println("Breakpoint hit here");
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(getProductRequestUrl,FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        GenericProductDto product=new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
      //  response.getStatusCode();
        return product;

    }
}
