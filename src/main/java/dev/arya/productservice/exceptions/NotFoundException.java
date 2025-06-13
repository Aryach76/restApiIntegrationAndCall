package dev.arya.productservice.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value= HttpStatus.NOT_FOUND) USED TO SIMPLE HANDLE OF EXCEPTIONS WITHOUT ANY SPECIFIC ERROR
public class NotFoundException extends Exception {
    public NotFoundException(String message) {

        super(message);
    }
}
