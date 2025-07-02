package dev.arya.productservice.repositories;

import dev.arya.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepo extends JpaRepository<Category, UUID> {

    Optional<Category> findByUuid(UUID uuid);

    List<Category> findAllByUuidIn(List<UUID> uuids);
}
