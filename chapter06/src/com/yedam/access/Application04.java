package com.yedam.access;

public class Application04 {
	public static void main(String[] args) {
		
		//Singleton.getInstance() = Singleton 클래스에서 만든 객체
		//싱글톤 내부 객체를 가져옴
		Singleton objt1 = Singleton.getInstance();
		Singleton objt2 = Singleton.getInstance();
		Singleton objt3 = Singleton.getInstance();
		Singleton objt4 = Singleton.getInstance();
		
		//주소값 모두 동일
		System.out.println(objt1);
		System.out.println(objt2);
		System.out.println(objt3);
		System.out.println(objt4);
		
		objt1.getInfo();
		//Singleton a = new Singleton(); -> 외부에서 객체 생성 불가능	
		
	}
}
