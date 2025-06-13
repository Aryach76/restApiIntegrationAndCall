package dev.arya.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Entity
@Builder
@Getter
@Setter
public class Product extends BaseModel{

    private String title;

    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private double price;
}
