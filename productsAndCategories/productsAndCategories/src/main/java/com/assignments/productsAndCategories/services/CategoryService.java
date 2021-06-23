package com.assignments.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.productsAndCategories.models.Category;
import com.assignments.productsAndCategories.models.Product;
//import com.assignments.productsAndCategories.models.Product;
import com.assignments.productsAndCategories.repositories.CategoryRepository;
//import com.assignments.productsAndCategories.repositories.ProductRepository;

@Service
public class CategoryService {
	private final CategoryRepository catRepo;

	public CategoryService(CategoryRepository catRepo) {
		this.catRepo = catRepo;
	}
	
	public Category create(Category newCategory) {
		return catRepo.save(newCategory);
	}
	
	public List<Category> getCategories() {
		return (List<Category>) catRepo.findAll();
	}
	
	
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = catRepo.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
    public Category updateCategory(Category category) {
		return catRepo.save(category);
	}
    
    public List<Category> findNotContaining(Product product){
    	return catRepo.findByproductsNotContaining(product);
    }

}
