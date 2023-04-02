package com.simplilearn.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BuyedProducts {
@Id
private int productid;
private int categoryid;
private double productweight;
private double productprice;
private String productdescription;
private LocalDate localdate;
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public int getCategoryid() {
	return categoryid;
}
public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}
public double getProductweight() {
	return productweight;
}
public void setProductweight(double productweight) {
	this.productweight = productweight;
}
public double getProductprice() {
	return productprice;
}
public void setProductprice(double productprice) {
	this.productprice = productprice;
}
public String getProductdescription() {
	return productdescription;
}
public void setProductdescription(String productdescription) {
	this.productdescription = productdescription;
}
public LocalDate getLocaldate() {
	return localdate;
}
public void setLocaldate(LocalDate localdate) {
	this.localdate = localdate;
}
public BuyedProducts(int productid, int categoryid, double productweight, double productprice,
		String productdescription, LocalDate localdate) {
	super();
	this.productid = productid;
	this.categoryid = categoryid;
	this.productweight = productweight;
	this.productprice = productprice;
	this.productdescription = productdescription;
	this.localdate = localdate;
}
public BuyedProducts() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "BuyedProducts [productid=" + productid + ", categoryid=" + categoryid + ", productweight=" + productweight
			+ ", productprice=" + productprice + ", productdescription=" + productdescription + ", localdate="
			+ localdate + "]";
}


}
