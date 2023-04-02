package com.simplilearn.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.simplilearn.entity.BuyedProducts;
import com.simplilearn.entity.Product;
import com.simplilearn.service.BuyedProductService;
import com.simplilearn.service.CategoryService;
import com.simplilearn.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	public CategoryService categoryservice;
	
	@Autowired
	public BuyedProductService buyedproduct;
	
	@Autowired
	public ProductService productservice;
	
	@GetMapping({"/","/home"})
	public String indexmethod()
	{
		return "index";
	}
	
	@GetMapping("/shop")
	public String shopmethod(Model model)
	{
		model.addAttribute("categories",categoryservice.listofcategory());
		model.addAttribute("products",productservice.getallProduct());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id)
	{
		model.addAttribute("categories",categoryservice.listofcategory());
		model.addAttribute("products", productservice.getAllProductsByCategoryId(id));
		return "shop";
	}
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model, @PathVariable int id)
	{
		model.addAttribute("product",productservice.getsingleProduct(id));
		
		return "viewProduct";
	}
	
	@GetMapping("/Buytheproduct/{id}")
	public String buytheproduct(@PathVariable int id,Model model)
	{
		Product product=productservice.getsingleProduct(id);
		BuyedProducts buyedproducts=new BuyedProducts();
		LocalDate date=LocalDate.now();
		buyedproducts.setProductid(product.getId());
		buyedproducts.setCategoryid(product.getCategory().getId());
		buyedproducts.setLocaldate(date);
		buyedproducts.setProductprice(product.getPrice());
		buyedproducts.setProductweight(product.getWeight());
		buyedproducts.setProductdescription(product.getDescription());
		buyedproduct.saveproducts(buyedproducts);
		return "index";
	}
}
