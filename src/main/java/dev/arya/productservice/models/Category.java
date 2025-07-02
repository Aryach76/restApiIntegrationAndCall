package dev.arya.productservice.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel{

    private String name;



    @OneToMany(mappedBy = "category")
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;
}
