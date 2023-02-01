package com.yedam.arrange;

import java.util.Calendar;

public class Exam01 {
	public static void main(String[] args) {
		//int a = 1;
		Week today = null;
		
		//오늘이 무슨 요일인지 알려주는 매소드
		Calendar cal = Calendar.getInstance();
		//1 = sunday, 2 = monday .....
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		
		System.out.println("오늘의 요일은 " + today);
		
		
		
		
		
		
		
		
		
	}
}
