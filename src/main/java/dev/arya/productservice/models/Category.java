package dev.arya.productservice.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel{

    private String name;



    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;
}
