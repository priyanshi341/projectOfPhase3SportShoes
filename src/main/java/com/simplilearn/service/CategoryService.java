package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.entity.Category;
import com.simplilearn.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository categoryrepository;
	
	public void addcategory(Category category)
	{
		categoryrepository.save(category);
	}
	
	public List<Category> listofcategory()
	{
		return categoryrepository.findAll();
	}
	
	public Category getsingledata(int id)
	{
		return categoryrepository.findById(id).get();
	}
	
	public void deletedata(int id)
	{
		categoryrepository.deleteById(id);
	}
}
