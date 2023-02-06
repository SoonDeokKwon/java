package com.yedam.inter;

public class interfaceExample {
	public static void main(String[] args) {
		
		RemoteControl rc;
		rc = new Televison();
		rc = new Audio();
		
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(12);
		rc.setVolume(-4);
		rc.turnOff();
		
		SmartTelevison tv = new SmartTelevison();
		
		//SmartTelevison -> 2개의 인터페이스 상속
		
		RemoteControl rc2 = tv;
		Searchable search = tv;
		
		rc2.setVolume(10);
		rc.turnOff();
		//rc2.search("www.naver.com"); -> RemoteControl 안에 있는 기능만 사용 가능
		search.search("www.naver.com");
		//search.setVolume(2); -> Searchable 안에 있는 기능만 사용 가능
		
		
		
	}
}
