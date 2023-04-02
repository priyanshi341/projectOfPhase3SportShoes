package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.entity.BuyedProducts;


public interface BuyedProductRepository extends JpaRepository<BuyedProducts,Integer>{

}
