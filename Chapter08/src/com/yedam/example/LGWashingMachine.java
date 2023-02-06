package com.yedam.example;

public class LGWashingMachine implements WashingMachine{
	
	

	@Override
	public void startBtn() {
		System.out.println("세탁을 시작합니다.");
	}

	@Override
	public void stopBtn() {
		System.out.println("세탁을 중지합니다.");
	}

	@Override
	public void endBtn() {
		System.out.println("세탁을 종료합니다.");
	}

	@Override
	public void dryBtn() {
		System.out.println("건조를 시작합니다.");
	}

	@Override
	public int speedChange(int speed) {
		int nowspeed = 0;
		switch(speed) {
		case 1:
			nowspeed = 20;
			break;
		case 2:
			nowspeed = 50;
			break;
		case 3:
			nowspeed = 100;
			break;	
		}
		return nowspeed;
	}
}
