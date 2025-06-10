package dev.arya.productservice.services;

import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.exceptions.NotFoundException;
import dev.arya.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.arya.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("FakestoreProductService")
public class FakestoreProductService implements ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakestoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient=fakeStoreProductServiceClient;
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

    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        return convertFakestoreToGenericProductDto(fakeStoreProductServiceClient.createProduct(product));
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException{

       return convertFakestoreToGenericProductDto(fakeStoreProductServiceClient.getProductById(id));

    }

    @Override
    public List<GenericProductDto> getProducts(){
        List<GenericProductDto>genericProductDtos=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getProducts()){
            genericProductDtos.add(convertFakestoreToGenericProductDto(fakeStoreProductDto));
        }
       return genericProductDtos;
    };

    @Override
    public GenericProductDto deleteProductById(Long Id){
        return convertFakestoreToGenericProductDto(fakeStoreProductServiceClient.deleteProductById(Id));

    }
}
