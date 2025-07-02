package dev.arya.productservice.services;

import dev.arya.productservice.models.Category;

import java.util.List;

public interface CategoryService {

    public Category getCategory(String uuid);

    public List<String> getProductTitles(List<String> categoryUUIDs);
}
