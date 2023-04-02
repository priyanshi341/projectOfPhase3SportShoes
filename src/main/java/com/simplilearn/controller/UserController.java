package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.simplilearn.entity.UserLogin;
import com.simplilearn.entity.UserSignedup;
import com.simplilearn.service.BuyedProductService;
import com.simplilearn.service.CategoryService;
import com.simplilearn.service.ProductService;
import com.simplilearn.service.UserSignedUpService;


@Controller
public class UserController {

	@Autowired
	public CategoryService categoryservice;
	
	@Autowired
	public ProductService productservice;
	
	@Autowired
	public UserSignedUpService userservice;
	
	@Autowired
	public BuyedProductService buyedproduct;
	
	@GetMapping("/user")
	public String userloginpage()
	{
		
		return "UserPage";
	}
	
	@GetMapping("/signup")
	public String usersignup(Model model)
	{
		model.addAttribute("user",new UserSignedup());
		return "UserSignupPage";
	}
	
	@PostMapping("/user")
	public String usersignupsone(@ModelAttribute("user") UserSignedup user)
	{
		userservice.saveuserdetails(user);
		return "UserLogin";
		
	}
	
	@GetMapping("/admin/users")
	public String displayusers(Model model)
	{
		List<UserSignedup> details=userservice.getalluserdata();
		model.addAttribute("allusers", details);
		
		return "AllUserDetails";
	}
	@GetMapping("/admin/buyedproducts")
	public String buyedproductsdetail(Model model)
	{
		model.addAttribute("buyedproducts", buyedproduct.getallbuyedproductsdetails());
		return "AllBuyedProductsDetails";
	}
	@GetMapping("/login")
	public String userlogin(Model model)
	{
		model.addAttribute("login", new UserLogin());
		return "UserLogin";
	}
	
	@PostMapping("/login")
	public String checkuserlogin(@ModelAttribute("login")UserLogin userlogin)
	{
		List<UserSignedup> usersignedup=userservice.getalluserdata();
		
		for(UserSignedup ref :usersignedup)
		{
			if(userlogin.getEmail().equals(ref.getEmail()))
			{
			  if(userlogin.getPassword().equals(ref.getPassword()))
			  {
				return "index";
			  }
				
			}
		}
		return "404";
	}
	
	@GetMapping("/user/logout")
	public String logoutpage()
	{
		return "redirect:/login";
	}
}
