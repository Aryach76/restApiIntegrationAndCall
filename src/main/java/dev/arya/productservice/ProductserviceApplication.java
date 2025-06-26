package dev.arya.productservice;

import dev.arya.productservice.models.Category;
import dev.arya.productservice.models.Price;
import dev.arya.productservice.models.Product;
import dev.arya.productservice.repositories.CategoryRepo;
import dev.arya.productservice.repositories.PriceRepo;
import dev.arya.productservice.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final PriceRepo priceRepo;

	public ProductserviceApplication(ProductRepo productRepo,
									 CategoryRepo categoryRepo,
									 PriceRepo priceRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.priceRepo = priceRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);

//		Product product=new Product();
//		product.setTitle("Iphone 15 Pro");
//		product.setDescription("Best Phone Ever");
//
//		product.save();
	}

	@Override
	public void run(String... args) throws Exception{
		Price price=new Price("rupee",12);
		//Price savedPrice=priceRepo.save(price);
		Category category=new Category();
		category.setName("Apple Devices");
		//Category savedCategory=categoryRepo.save(category);
				Product product=new Product();
			 	productRepo.deleteById(UUID.fromString("92d18fff-726b-403a-a598-3addab01b5a3"));
		product.setTitle("Iphone 15 Pro");
		product.setDescription("Best Phone Ever");
		product.setCategory(category);
		product.setPrice(price);
		productRepo.save(product);

	}

}
