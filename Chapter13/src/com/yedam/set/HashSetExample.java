package com.yedam.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		set.add("java");
		set.add("JDBC");
		set.add("Servelt/JSP");
		set.add("Java");
		set.add("iBatis");
		
		int size = set.size();
		System.out.println("총 객체 수 : " + size);
		
		//반복자를 활용한 HashSet 객체 출력
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("java");
		set.remove("JDBC");
		System.out.println("====================");
		
		
		for(String temp : set) {
			System.out.println("\t" + temp);
		}
		
		set.clear();
		
		System.out.println("총 객체 수 : " + set.size());
		
		if(set.isEmpty()) {
			System.out.println("객체ㅔ가 존재하지 않습니다.");
		}
		
		
	}
}
