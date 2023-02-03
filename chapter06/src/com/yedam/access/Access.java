package com.yedam.access;

public class Access {
	/*
	 * 사용 : 필드, 메소드, 클래스, 인터페이스 등 앞에 사용가능
	 * public 어디서든 누구나 다 접근 가능 ex) 필드 -> 누구나 다 쓸 수 있다
	 * protected 상속이라는 관계 맺은 다음에 부모-자식 간에 사용(패키지가 달라도 사용가능)
	 *           같은 패키지에서만 접근 가능, 서로 다른 패키지면 접근 불가능
	 * default 서로 다른 패키지면 접근 불가, 같은 패키지에서만 접근 가능
	 * private 내가 속한 클래스에서만 사용 가능
	 * 
	 */
	
	//필드
	public String free;
	protected String parent;
	private String privacy;
	String basic;
	
	
	//생성자에 접근 제한자 -> 객체를 생성하는 범위를 조절
	//public -> 어디서든 객체 생성 가능
	//protected -> 같은 패키지, 자식 클래스에서만 객체 생성 가능
	//default -> 같은 패키지에서만 객체 생성 가능
	//private -> 객체 생성 불가능
	public Access() {
		
	}
	protected Access(int a) {
		
	}
	Access(String s) {
		
	}
	private Access(double a) {
		
	}
	
	
	//메소드
	//숨기고 싶은 정보
	private void info() {
		System.out.println("private 메소드");
	}
	//숨긴 정보를 대신 불러주는 메소드
	public void instead() {
		info();
	}
	protected void parent() {
		System.out.println("protected 메소드");
	}
	void basic() {
		System.out.println("default 메소드");
	}
	
}
