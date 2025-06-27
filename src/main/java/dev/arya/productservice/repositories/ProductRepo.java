package dev.arya.productservice.repositories;

import dev.arya.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ProductRepo extends JpaRepository<Product,UUID> {


    Product findByTitleEquals(String title);
    Product findByTitleAndPrice_Price(String title,double price);
    List<Product> findAllByPrice_Currency(String currency);

    @Query(value = "select * from Product where title=:titlename",nativeQuery = true)
    List<Product> findAllByTitle(String titlename);

    @Query(value = "select Product from Product where Product.title",nativeQuery = true)
    List<Product> readAllByTitle(String titlename);




}
