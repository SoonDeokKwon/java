package com.yedam.inheri;

public class Application03 {
	public static void main(String[] args) {

		Compute compute = new Compute();
		compute.areaCircle(5.0);
		
		Exam exam = new Exam();
		exam.method01(); //자식 클래스 method01
		exam.method02(); //부모 클래스 method02

	}
}
