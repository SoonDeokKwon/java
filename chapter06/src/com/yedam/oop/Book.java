package com.yedam.oop;

public class Book {
	//Book 이라는 클래스는 아래의 정보를 가져야 합니다.
	// 책 이름, 책 종류, 가격, 도서번호, 출판사
	
	//생성자는 3개 생성
	//1)기본
	//데이터(매개변수) -> 필드를 초기화 할 수 있게끔 생성자 생성
	//2)모든 데이터를 초기화 할 수 있는 생성자
	//3) 책 이름, 책 가격, 도서번호를 받아오는 생성자
	
	//메소드는 getInfo() 메소드를 가짐.
	//getIngo() 메소드를 클래스 외부에서 실행 하였을 때,
	//다음과 같은 출력물이 나오도록 구현.
	/*
	 * 책 이름 : 혼자 공부하는 자바
	 * #내용
	 * 1) 종류 : 학습서
	 * 2) 가격 : 24000원
	 * 3) 출판사 : 한빛 미디어
	 * 4) 도서번호 : 0001 
	 */
	
	
	//필드
	String bookName;
	String kind;
	int price;
	String isbn;
	String company;
	
	//생성자
	//1)기본
	public Book() {
	}
	//2)모든 데이터를 초기화 할 수 있는 생성자
	public Book(String bookName, String kind, int price, String isbn, String company) {
		this.bookName = bookName;
		this.kind = kind;
		this.price =  price;
		this.isbn = isbn;
		this.company = company;	
	}
	//3) 책 이름, 책 가격, 도서번호를 받아오는 생성자
	public Book(String bookName, int price, String isbn) {
		this.bookName = bookName;
		this.price = price;
		this.isbn = isbn;
	}
	
	//메소드
	void getInfo() {
		System.out.println("책 이름 : " + bookName );
		System.out.println("# 내용");
		System.out.println("1) 종류 : " + kind );
		System.out.println("2) 가격 : " + price +"원" );
		System.out.println("3) 출판사 : " + company );
		System.out.println("4) 도서번호 : " + isbn );
	}
	
	
	
	
}
