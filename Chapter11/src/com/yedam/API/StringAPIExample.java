package com.yedam.API;

public class StringAPIExample {
	public static void main(String[] args) {
		//1) 문자열 뒤집기
		//String str = "abcdefg" -> "gfedcba"
		//			    문자열 길이 =>7
		
		String str = "abcdefg";
		
		String newStr = str.replace("abcdefg", "gfedcba");
		System.out.println(newStr);
		
		for(int i = str.length()-1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		
		
	}
}
