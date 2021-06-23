package com.assignments.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.productsAndCategories.models.Category;
import com.assignments.productsAndCategories.models.Product;
import com.assignments.productsAndCategories.repositories.ProductRepository;



@Service
public class ProductService {
	private final ProductRepository prodRepo;

	public ProductService(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	public Product create(Product newProduct) {
		return prodRepo.save(newProduct);
	}
	
	public List<Product> getProducts() {
		return (List<Product>) prodRepo.findAll();
	}
	
	
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = prodRepo.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
    public Product updateProduct(Product product) {
		return prodRepo.save(product);
	}
    
    public List<Product> findNotContaining(Category category){
    	return  prodRepo.findBycategoriesNotContaining(category);    
    }
	
}
