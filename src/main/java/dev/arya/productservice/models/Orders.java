package dev.arya.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Orders extends BaseModel{

    @ManyToMany
    @JoinTable(name = "Product_orders",joinColumns = @JoinColumn(name="order_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product;
}
