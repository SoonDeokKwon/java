package com.sd.homework;

public class Product {
	
	//�ʵ�
	String productName;
	int price;
	
	//������
	public Product() {
		
	}
	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;		
	}
	
	//�޼ҵ�
	void getInfo() {
		System.out.println(productName + " : " + price);
	}
	
}
