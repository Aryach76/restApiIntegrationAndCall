package dev.arya.productservice;

import dev.arya.productservice.models.Category;
import dev.arya.productservice.models.Product;
import dev.arya.productservice.repositories.CategoryRepo;
import dev.arya.productservice.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;

	public ProductserviceApplication(ProductRepo productRepo,
									 CategoryRepo categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
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

		Category category=new Category();
		category.setName("Apple Devices");
		Category savedCategory=categoryRepo.save(category);
				Product product=new Product();
		product.setTitle("Iphone 15 Pro");
		product.setDescription("Best Phone Ever");
		product.setCategory(savedCategory);
		productRepo.save(product);

	}

}
