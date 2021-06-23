package com.assignments.productsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.productsAndCategories.models.Category;
import com.assignments.productsAndCategories.models.Product;
import com.assignments.productsAndCategories.services.CategoryService;
import com.assignments.productsAndCategories.services.ProductService;

@Controller
public class HomeController {
	private final ProductService prodService;
	private final CategoryService catService;
	
	public HomeController(ProductService prodService, CategoryService catService) {
		this.prodService = prodService;
		this.catService = catService;
	}
	
	//products section
	@GetMapping("/products/new")
	public String newProduct(Model model) {
		
		model.addAttribute("newProduct", new Product());	
		return "newProduct.jsp";
	}
	
	@PostMapping("/products")
	public String createProducts(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result ) {
		if(result.hasErrors()) {
			
		
		return "newProduct.jsp";
		}
	
		prodService.create(newProduct);
		return "redirect:/products/"+ newProduct.getId();
		
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id) {
		
		
		Product product = prodService.findProduct(id);		
		
		List<Category> catInProducts = product.getCategories();
		//List<Category> allCategories = catService.getCategories();
		List<Category> allCategories = catService.findNotContaining(product);
		
		model.addAttribute("product", product);
		model.addAttribute("catInProducts", catInProducts);
		model.addAttribute("allCategories", allCategories);
		
		return "productPage.jsp";
	}
	
	@PostMapping("/addCatToProd")
	public String addCatToProd(Model model, @RequestParam("productId") Long productId,  @RequestParam("categoryId") Long categoryId) {
		
		Product product = prodService.findProduct(productId);
		List<Category> catInProducts = product.getCategories();	
		Category category = catService.findCategory(categoryId);	
		catInProducts.add(category);
		product.setCategories(catInProducts);
		prodService.updateProduct(product);
		
		return "redirect:/products/" + productId;
	}
	
	
	
	
	
	
	
	//.....................................................................................................................
	//...........................................Categories.................................................................
	//......................................................................................................................
	
	
	
	//Categories section
	@GetMapping("/categories/new")
	public String newCategory(Model model) {
		
		model.addAttribute("newCategory", new Category());	
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories")
	public String createCategories(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result ) {
		
		if(result.hasErrors()) {	
			
		return "newCategory.jsp";
		}
	
		catService.create(newCategory);
		return "redirect:/categories/"+ newCategory.getId();
		
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(Model model, @PathVariable("id") Long id) {
		
		Category category = catService.findCategory(id);
		List<Product> productsInCat = category.getProducts();
		//List<Product> allProducts = prodService.getProducts();
		List<Product> allProducts = prodService.findNotContaining(category);
		
		model.addAttribute("category", category);	
		model.addAttribute("productsInCat", productsInCat);
		model.addAttribute("allProducts", allProducts);
		
		return "categoryPage.jsp";
	}
	
	@PostMapping("/addProductToCat")
	public String addProductToCat(Model model, @RequestParam("productId") Long productId,  @RequestParam("categoryId") Long categoryId) {
		
		Category category = catService.findCategory(categoryId);
		List<Product> productsInCat = category.getProducts();
		Product product = prodService.findProduct(productId);
		productsInCat.add(product);
		category.setProducts(productsInCat);
		catService.updateCategory(category);
		
		return "redirect:/categories/" + categoryId;
	}
	
	
	
	
	
	

}
