package com.yedam.inheri;

public class DmbCellphone extends Cellphone {
	
	//자식 클래스
	//필드
	int channel;
	
	
	//생성자
	public DmbCellphone(String model, String color, int channel) {
		//부모 클래스의 생성자를 사용할 때 쓰는 키워드, super
		//super(); -> 부모가 가진 기본 생성자를 가져옴
		super(model,color);
		//부모 클래스에 있는 필드(model, color)
		this.model = model;
		this.color = color;
		//자식 클래스에 있는 필드(channel)
		this.channel = channel;
	}
	
	//메소드
	void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB 방송 수신");
	}
	
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
	
	
	
	
	
}
