package com.yedam.list;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {
		//List<E>
		List<String> list = new ArrayList<String>();
		
		
		//list 데이터 추가
		list.add("Java"); //인덱스 0 데이터 추가
		list.add("JDBC"); //인덱스 1 데이터 추가
		list.add("Servelt/JSP"); //인덱스 2 데이터 추가
		//인덱스 2 데이터 추가 -> 인덱스 2: DataBase, 인덱스3: Servelt/JSP
		list.add(2, "DataBase");
		list.add("iBatis");
		
		//list.size() -> list의 크기 (배열로 치면 length)
		for(int i=0; i<list.size(); i++) {
			//list.get -> 해당 인덱스의 객체를 꺼내옴
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		
		System.out.println("================================");
		//list.remove(index) -> 해당 인덱스의 객체 삭제
		list.remove(2); //index 
		for(int i=0; i<list.size(); i++) {
			//list.get -> 해당 인덱스의 객체를 꺼내옴
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}

		System.out.println("================================");
		//객체를 꼭 집어서 삭제
		list.remove("JDBC");
		for(int i=0; i<list.size(); i++) {
			//list.get -> 해당 인덱스의 객체를 꺼내옴
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		
		System.out.println("================================");
		//리스트 객체 전부 삭제
		list.clear();
		//list.size() -> 길이가 0이면 객체가 다 삭제됨을 의미.
		System.out.println(list.size());
		
		
		//contains()
		//isEmpty()
		
		
		
	}
}
