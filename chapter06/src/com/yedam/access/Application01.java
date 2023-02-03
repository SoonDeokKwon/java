package com.yedam.access;

public class Application01 {
	public static void main(String[] args) {
		Access ac = new Access();
		
		//public
		ac.free = "public";
		//protected
		ac.parent = "parent";
		//default
		ac.basic = "default";
		//private
		//ac.privacy = "privacy"; -> 오류
		
		ac.instead();
		ac.parent();
		ac.basic();
		
	}
}
