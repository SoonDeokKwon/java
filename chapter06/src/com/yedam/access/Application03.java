package com.yedam.access;

public class Application03 {
	public static void main(String[] args) {
		Member member = new Member();
		
		member.setId("sdkwon93");
		member.setPassword("asd1324");
		member.setName("권순덕");
		member.setAge(30);
		
		System.out.println("아이디 : " + member.getId());
		System.out.println("비밀번호 : " + member.getPassword());
		System.out.println("이름 : " + member.getName());
		System.out.println("나이 : " + member.getAge());
		
	}
}
