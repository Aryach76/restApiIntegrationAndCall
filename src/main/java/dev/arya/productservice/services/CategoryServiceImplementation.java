package dev.arya.productservice.services;

import dev.arya.productservice.models.Category;
import dev.arya.productservice.models.Product;
import dev.arya.productservice.repositories.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImplementation implements CategoryService{

    private CategoryRepo categoryRepo;

    public CategoryServiceImplementation(CategoryRepo categoryRepo){
        this.categoryRepo=categoryRepo;
    }
    @Override
    public Category getCategory(String uuid){
        Optional<Category> categoryOptional=categoryRepo.findById(UUID.fromString(uuid));
        if(categoryOptional.isEmpty())
            return null;
        Category category=categoryOptional.get();
//        List<Product> products=category.getProducts();
        return category;
    }
}
