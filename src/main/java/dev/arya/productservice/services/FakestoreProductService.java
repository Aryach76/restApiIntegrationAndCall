package dev.arya.productservice.services;

import dev.arya.productservice.dtos.FakeStoreProductDto;
import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service("FakestoreProductService")
public class FakestoreProductService implements ProductService {


    private  RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestUrl ="https://fakestoreapi.com/products/{id}";
    private String productRequestBaseUrl="https://fakestoreapi.com/products";

    public FakestoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }


    private GenericProductDto convertFakestoreToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product=new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        //  response.getStatusCode();
        return product;
    }

    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response=restTemplate.postForEntity(productRequestBaseUrl,product,GenericProductDto.class);

        return response.getBody();
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException{

        RestTemplate restTemplate=restTemplateBuilder.build();
        System.out.println("Breakpoint hit here");
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(specificProductRequestUrl,FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id: " + id + " Not Found");
        }
       return convertFakestoreToGenericProductDto(fakeStoreProductDto);

    }

    @Override
    public List<GenericProductDto> getProducts(){
       RestTemplate restTemplate=restTemplateBuilder.build();
       ResponseEntity<FakeStoreProductDto[]> response=restTemplate.getForEntity(productRequestBaseUrl,FakeStoreProductDto[].class);
       List<GenericProductDto> answer= new ArrayList<>();

       for( FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()){

           answer.add(convertFakestoreToGenericProductDto(fakeStoreProductDto));
       }

       return answer;
    };

    @Override
    public GenericProductDto deleteProductById(Long Id){

        RestTemplate restTemplate=restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response=restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, Id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
//        if(fakeStoreProductDto==null)
//            throw new NotFoundException("Product with id: "+Id+" Not Found");
        return convertFakestoreToGenericProductDto(fakeStoreProductDto);

    }
}
