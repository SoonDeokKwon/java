package com.yedam.service;

public class Coffee {
	//Coffee에 대한 정보, 데이터를 보관하고 출력할 때 사용
	//DTO = Data Transfer Object(정보 보관)
	//VO = Value Object(정보 보관 + 기능 추가)
	//Beans = DTO, VO와 같은 의미
	
	
	//필드
	private int coffeeId;
	private String coffeeMenu;
	private int coffeePrice;
	private String coffeeExplain;
	private int coffeeSales;
	
	
	public int getCoffeeId() {
		return coffeeId;
	}
	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}
	public String getCoffeeMenu() {
		return coffeeMenu;
	}
	public void setCoffeeMenu(String coffeeMenu) {
		this.coffeeMenu = coffeeMenu;
	}
	public int getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	public String getCoffeeExplain() {
		return coffeeExplain;
	}
	public void setCoffeeExplain(String coffeeExplain) {
		this.coffeeExplain = coffeeExplain;
	}
	public int getCoffeeSales() {
		return coffeeSales;
	}
	public void setCoffeeSales(int coffeeSales) {
		this.coffeeSales = coffeeSales;
	}
	
	
	
	
}
