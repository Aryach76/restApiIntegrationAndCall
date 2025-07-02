package dev.arya.productservice.services;

import dev.arya.productservice.models.Category;
import dev.arya.productservice.repositories.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private CategoryRepo categoryRepo;

    public CategoryServiceImplementation(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public Category getCategory(String uuid) {
        Optional<Category> categoryOptional = categoryRepo.findById(UUID.fromString(uuid));
        if (categoryOptional.isEmpty())
            return null;
        Category category = categoryOptional.get();
//        List<Product> products=category.getProducts();
        return category;
    }

    @Override
    public List<String> getProductTitles(List<String> categoryUUIDs) {
        List<UUID> uuids = new ArrayList<>();
        for (String uuid : categoryUUIDs) {
            uuids.add(UUID.fromString(uuid));
        }
        List<Category> categories = categoryRepo.findAllByUuidIn(uuids);

        List<String> titles = new ArrayList<>();

        categories.forEach(
                category -> {
                    category.getProducts().forEach(
                            product -> {
                                titles.add(product.getTitle());
                            }
                    );
                }

        );
        return titles;
    }
}
