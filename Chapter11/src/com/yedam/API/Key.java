package com.yedam.API;

public class Key {
	public int Key;
	
	public Key(int Key) {
		this.Key = Key;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key compare = (Key) obj;
			if(this.Key == compare.Key) {
		}
		return super.equals(obj);
	}
	return false;

	}
	
	@Override
	public int hashCode() {
		//데이터가 같으면 같은 hashCode를 가질 수 있도록
		//재정의
		return Key;
	}
	
	
}
