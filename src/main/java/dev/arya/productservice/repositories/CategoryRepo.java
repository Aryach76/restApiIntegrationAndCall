package dev.arya.productservice.repositories;

import dev.arya.productservice.models.Category;
import dev.arya.productservice.services.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepo extends JpaRepository<Category, UUID> {

    @Override
    Optional<Category> findById(UUID uuid);
}
