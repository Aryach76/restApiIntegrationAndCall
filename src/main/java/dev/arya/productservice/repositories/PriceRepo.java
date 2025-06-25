package dev.arya.productservice.repositories;

import dev.arya.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepo extends JpaRepository<Price,Long> {


}
