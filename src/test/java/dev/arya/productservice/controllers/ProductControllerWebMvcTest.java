package dev.arya.productservice.controllers;


import dev.arya.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//will not initialize any unnecesssary bean
//will initialize that is used in test
@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    @Qualifier("FakestoreProductService")
    private ProductService productService;

    @Test
    void getAllProductReturnEmptyListWhenNoProduct() throws Exception {

        when(productService.getProducts())
                .thenReturn(new ArrayList<>());
        mockMvc.perform(
                get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));

    }
}
