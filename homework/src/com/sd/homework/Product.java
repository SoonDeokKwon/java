package com.sd.homework;

public class Product {
	
	//필드
	String productName;
	int price;
	
	//생성자
	public Product() {
		
	}
	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;		
	}
	
	//메소드
	void getInfo() {
		System.out.println(productName + " : " + price);
	}
	
}
