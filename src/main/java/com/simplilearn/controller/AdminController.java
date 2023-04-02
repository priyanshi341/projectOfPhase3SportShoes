package com.simplilearn.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplilearn.dto.ProductDto;
import com.simplilearn.entity.AdminTable;
import com.simplilearn.entity.Category;
import com.simplilearn.entity.Product;
import com.simplilearn.service.AdminService;
import com.simplilearn.service.CategoryService;
import com.simplilearn.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	public AdminService adminservice;
	
	@Autowired
	public CategoryService categoryservice;
	
	@Autowired
	public ProductService productservice;
	
	@GetMapping("/admin")
	public String adminlogin(Model model)
	{
		model.addAttribute("admin",new AdminTable());
		return "AdminLogin";
	}
	
	@PostMapping("/admin")
	public String adminlogincheck(@ModelAttribute("admin") AdminTable admintable)
	{
		AdminTable ref=adminservice.getadmindetail("1234@gmail.com");
		
		if(admintable.adminemail.equals(ref.adminemail))
		{
			if(admintable.password.equals(ref.password))
			{
				return "AdminHome";
			}
		}
		else
		{
			return "404";
		}
		
	    return "";
		
	}
	
	@GetMapping("/admin/update")
	public String updateadmin(Model model)
	{
		model.addAttribute("admin",new AdminTable());
		return "AdminUpdate";
	
	}
	@PostMapping("/admin/update/done")
	public String updatedoneofadmin(@ModelAttribute("admin") AdminTable admintable)
	{
		AdminTable ref=adminservice.getadmindetail("1234@gmail.com");
		ref.setPassword(admintable.getPassword());
		adminservice.addadmin(ref);
		return "AdminHome";
	}
	
	
	@GetMapping("/admin/categories")
	public String getcat(Model model)
	{
		model.addAttribute("allcategory", categoryservice.listofcategory());
	   return "categories";	
	}
	
	@GetMapping("/admin/categories/add")
	public String addcategories(Model model)
	{
		Category c=new Category();
		model.addAttribute("category",c);
		return "addcategories";
	}
	
	@PostMapping("/admin/categories/add/added")
	public String added(@ModelAttribute("category") Category category)
	{
		categoryservice.addcategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/update/{id}")
	public String update(@PathVariable int id,Model model)
	{
		Category c=categoryservice.getsingledata(id);
			model.addAttribute("category", c);
			return "addcategories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String delete(@PathVariable int id)
	{
		categoryservice.deletedata(id);
		return "redirect:/admin/categories";
	}
	
	//Product Section
	
	@GetMapping("/admin/products")
	public String getproduct(Model model)
	{
		model.addAttribute("products", productservice.getallProduct());
		return "product";
	}
	
	@GetMapping("/admin/products/add")
	public String addproduct(Model model)
	{
		model.addAttribute("productDTO", new ProductDto());
		model.addAttribute("categories", categoryservice.listofcategory());
		return "productadd";
	}
	
	@PostMapping("/admin/products/add")
	public String addingproductdata(@ModelAttribute("productDTO") ProductDto productdto)
	{
		Product ref=new Product();
		ref.setId(productdto.getId());
		ref.setName(productdto.getName());
		ref.setCategory(categoryservice.getsingledata(productdto.getCategoryId()));
		ref.setPrice(productdto.getPrice());
		ref.setWeight(productdto.getWeight());
		ref.setDescription(productdto.getDescription());
		productservice.saveProduct(ref);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/update/{id}")
	public String updateproduct(@PathVariable int id,Model model)
	{
		Product ref=productservice.getsingleProduct(id);
	   ProductDto productdto=new ProductDto();
	   productdto.setCategoryId(ref.getCategory().getId());
	   productdto.setId(ref.getId());
	   productdto.setName(ref.getName());
	   productdto.setDescription(ref.getDescription());
	   productdto.setPrice(ref.getPrice());
	   productdto.setWeight(ref.getWeight());
	   model.addAttribute("productDTO", productdto);
	   model.addAttribute("categories", categoryservice.listofcategory());
		return "productadd";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteproduct(@PathVariable int id)
	{
		productservice.deleteProduct(id);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/logout")
	public String adminlogout()
	{
		return "redirect:/admin";
	}
}
