package dev.arya.productservice.thirdpartyclients.productservice.fakestore;

import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.exceptions.NotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service


public class FakeStoreProductServiceClient {

    private RestTemplateBuilder restTemplateBuilder;



    private String fakeStoreApiUrl;


    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductApiPath;

    private String specificProductRequestUrl;
    private String productRequestBaseUrl;


    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreApiUrl,@Value("${fakestore.api.paths.product}") String fakeStoreProductApiPath){
        this.restTemplateBuilder=restTemplateBuilder;
        this.productRequestBaseUrl= fakeStoreApiUrl + fakeStoreProductApiPath;
        this.specificProductRequestUrl=fakeStoreApiUrl + fakeStoreProductApiPath+"/{id}";
    }




    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity(productRequestBaseUrl,product,FakeStoreProductDto.class);

        return response.getBody();
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException{

        RestTemplate restTemplate=restTemplateBuilder.build();
        System.out.println("Breakpoint hit here");
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(specificProductRequestUrl,FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id: " + id + " Not Found");
        }
        return fakeStoreProductDto;

    }


    public List<FakeStoreProductDto> getProducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=restTemplate.getForEntity(productRequestBaseUrl,FakeStoreProductDto[].class);
        List<GenericProductDto> answer= new ArrayList<>();

        return Arrays.asList(response.getBody());
    };


    public FakeStoreProductDto deleteProductById(Long Id){

        RestTemplate restTemplate=restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response=restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, Id);
//        if(fakeStoreProductDto==null)
//            throw new NotFoundException("Product with id: "+Id+" Not Found");
        return response.getBody();

    }
}
