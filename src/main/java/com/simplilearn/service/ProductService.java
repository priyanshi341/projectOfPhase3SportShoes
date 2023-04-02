package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Product;
import com.simplilearn.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrepository;
	
	public List<Product> getallProduct()
	{
		return productrepository.findAll();
	}
	
	public Product getsingleProduct(int id)
	{
		return productrepository.findById(id).get();
	}
	
	public void saveProduct(Product product)
	{
		productrepository.save(product);
	}
	
	public void deleteProduct(int id)
	{
		productrepository.deleteById(id);
	}
	
	public List<Product> getAllProductsByCategoryId(int id)
	{
		List<Product> result=new ArrayList<Product>();
		List<Product> p=productrepository.findAll();
		for(Product ref:p)
		{
			if(ref.getCategory().getId()==id)
			{
				result.add(ref);
			}
		}
		return result;
	}
	
}
