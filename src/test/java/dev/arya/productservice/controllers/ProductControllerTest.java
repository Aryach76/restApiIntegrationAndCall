package dev.arya.productservice.controllers;


import dev.arya.productservice.dtos.GenericProductDto;
import dev.arya.productservice.exceptions.NotFoundException;
import dev.arya.productservice.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;

    @Test
    void returnNullWhenProductDoesNotExist() throws NotFoundException {
        GenericProductDto genericProductDto=productController.getProductById(121L);
        when(productService.getProductById(121L))
                .thenReturn(null);

        assertNull(genericProductDto);
    }

    @Test
    @DisplayName("My Custom Test case test")
    void testOnePlusOneEqualIsTrue(){
        System.out.println("This Is True");
        assertEquals(2==1+1,"sum is not equal to expected");
    }
}

//Assertion framework
//->Allows u to make assertions
//-> allows you to make checks
