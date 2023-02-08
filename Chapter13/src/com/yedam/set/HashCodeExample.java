package com.yedam.set;

import java.util.HashSet;
import java.util.Set;

public class HashCodeExample {
	public static void main(String[] args) {
		
		Set<Member> set = new HashSet<>();
		
		set.add(new Member(("고길동"),30));
		set.add(new Member(("고길동"),26));
		
		System.out.println("총 객체 수 : " + set.size() );
		
	}
}
