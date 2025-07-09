package dev.arya.productservice.controllers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductControllerTest {

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
