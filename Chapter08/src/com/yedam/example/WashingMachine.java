package com.yedam.example;

public interface WashingMachine extends DryingMachine {
	//시작버튼, 중지버튼, 종료버튼, 속도 변경 버튼
	
	public void startBtn();
	
	public void stopBtn();
	
	public void endBtn();
	
	public int speedChange(int speed);
}
