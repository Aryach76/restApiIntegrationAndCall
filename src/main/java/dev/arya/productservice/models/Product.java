package dev.arya.productservice.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel{

    private String title;

    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    private Price price=new Price();
}
