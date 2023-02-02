package com.yedam.include;

import com.yedam.access.Access;

public class Application02{
	public static void main(String[] args) {
		Access ac = new Access();
		
		
		ac.free = "public";
		//ac.parent = "parent";  
		//ac.privacy = "privacy";  
		//ac.basic = "basic";  
		
		ac.instead();
		//ac.info();
		//ac.parent();
		//ac.basic();
		
	}
}
