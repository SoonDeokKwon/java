package com.yedam.API;

import java.io.UnsupportedEncodingException;

public class StringAPI {
	public static void main(String[] args) {
		
		//StringAPI
		
		
		//byte[] -> String 변환
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		
		//내가 원하는 위치를 선정(6)하고 그 갯수(4)만큼 출력
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
		
		
		//charAt()
		//인덱스 값(문자 위치)를 입력해서 해당 위치에 있는 문자 가져오기
		String ssn = "010645 - 1579854";
		char gender = ssn.charAt(7);
		
		switch(gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}
	
		
		//equals()
		
		String str3 = "김또치";
		String str4 = "김또치";
		String str5 = new String("김또치");
		
		if(str3.equals(str4)) {
			System.out.println("같은 문자열");
		}else {
			System.out.println("다른 문자열");
		}
		if(str3.equals(str5)) {
			System.out.println("같은 문자열2");
		}else {
			System.out.println("다른 문자열2");
		}
		
		//바이트 배열로 변환
		//String -> byte 변환
		String str6 = "안녕하세요";
		byte[] byte1 = str6.getBytes();
		System.out.println(byte1.length);
		
		
		
		//byte -> String
		String str7 = new String(byte1);
		System.out.println("byte -> String : " + str7);
		
		
		//byte <-> String + encoding type
		try {
			byte[] byte2 = str6.getBytes("EUC-KR");
			System.out.println("byte2.length : " + byte2.length);
			String str8 = new String(byte2,"EUC-KR");
			System.out.println(str8);
			
			byte[] byte3 = str6.getBytes("UTF-8");
			System.out.println("byte3.lenght : " + byte3.length);
			String str9 = new String(byte3,"UTF-8");
			System.out.println(str9);
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		//문자열 찾기 - indextOf
		String subject = "자바 프로그래밍";
		int index = subject.indexOf("로");
		System.out.println(index);
		
		
		//문자열 길이
		System.out.println(subject.length());
		
		String ssn2 = "000102-3157849";
		if(ssn2.length() == 14) {
			System.out.println("주민번호 자리 수 맞음");
		}else {
			System.out.println("주민번호 자리 수 틀림");
		}
		
		
		//문자열 대치(문자열 바꾸기)
		String oldStr = "자바 프로그래밍";
		String newStr = oldStr.replace("자바", "Java");
		System.out.println(newStr);
		
		
		//문자열 자르기
		//매개변수에 따라서 자르느 방법이 다름
		//1) 매개변수가 1개일 때; 해당 위치부터 뒤로 다 짤라
		String ssn3  = "132456-1234567";
		String firstNum = ssn3.substring(7);
		System.out.println(firstNum);
		
		//2) 매개변수가 2개일 때; 시작점~끝나는 위치
		String secondNum = ssn.substring(0,6);
		System.out.println(secondNum);
		
		
		//대문자 -> 소문자
		String DaeMoonJa = "ABCDEFG";
		System.out.println(DaeMoonJa.toLowerCase());
		
		//소문자 -> 대문자
		String somonja = "abcdefg";
		System.out.println(somonja.toUpperCase());
		
		
		//공백제거 -Trim
		String name =  "   고희동   ";
		System.out.println(name.trim());
		
		//기본타입 -> 문자열 변환(String, valueOf)
		String temp = String.valueOf(123);
		temp = String.valueOf(true);
		System.out.println(temp);
		System.out.println();
		
		//문자열 분리하기 -  split()
		//구분자를 통한 문자열 분리
		String value = "1,2,3,4,5,6,7,8,9";
		
		String[] strAry = value.split(",");
		
		for(String data : strAry) {
			System.out.println(data);
		}
		
		
		//contact 문자열 합치기
		String var = "또치";
		System.out.println(var.concat("김"));
		
		//isEmpty
		if(var.contains("또")) {
			System.out.println("또 포함 됨");
		}else {
			System.out.println("또 포함 안됨");
		}
		
		String empty = "";
		if(empty.isEmpty()) {
			System.out.println("비었음.");
		}else {
			System.out.println("안 비었음.");
		}
		
		//String 단점을 보완해주는 API
		//StringBuilder: 하나의 메모리로 문자열 수정
		//StringBufer : 하나의 메모리로 문자열 수(비슷)
		StringBuilder sb = new StringBuilder();
		sb.append("예");
		sb.append("담");
		System.out.println(sb);
		
		
	}
}
