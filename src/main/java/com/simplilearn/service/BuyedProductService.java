package com.simplilearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.BuyedProducts;
import com.simplilearn.repository.BuyedProductRepository;

@Service
public class BuyedProductService {

	@Autowired
	BuyedProductRepository buyedproducts;
	
	
	public void saveproducts(BuyedProducts buyproducts)
	{
		buyedproducts.save(buyproducts);
	}
	
	public List<BuyedProducts> getallbuyedproductsdetails()
	{
		return buyedproducts.findAll();
	}
}
