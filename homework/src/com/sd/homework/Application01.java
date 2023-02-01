package com.sd.homework;

import java.util.Scanner;

public class Application01 {
	public static void main(String[] args) {
		// ����1) ������ Ű����κ��� ��ǰ ���� ��ǰ ������ �Է¹޾Ƽ�
		// �ְ� ������ ������ ��ǰ�� �ش� ��ǰ�� ������ ��ǰ���� �� ���� ���ϴ� ���α׷��� �ۼ��ϼ���.
		// 1) �޴��� ������ ���� �����ϼ���.
		// 1.��ǰ �� | 2.��ǰ �� �����Է� | 3.��ǰ�� ���� | 4.�м� | 5.����
		// 2) �Է��� ��ǰ ����ŭ ��ǰ��� �ش� ������ �Է¹��� �� �ֵ��� �����ϼ���.
		// 3) ��ǰ�� ������ ����ϼ���.
		//	��¿���, "��ǰ�� : ����"
		// 4) �м������ �ְ� ������ ������ ��ǰ�� �ش� ��ǰ�� ������ ��ǰ���� ������ ���մϴ�.
		// 5) ���� �ÿ��� ���α׷��� �����Ѵٰ� �޼����� ����ϵ��� �����ϼ���.
		
		
		
		// 1) �޴��� ������ ���� �����ϼ���.
		//��ǰ �� �Է� �޴� �뵵
		Scanner sc = new Scanner(System.in);
		
		//��ǰ ���� �Է¹޴� ����
		int pdutCount = 0;
		
		//��ǰ�� ������ �����ϴ� �迭 ����
		Product [] pductArr = null;
		
		// 1.��ǰ �� | 2.��ǰ �� �����Է� | 3.��ǰ�� ���� | 4.�м� | 5.����
		while (true) {
			System.out.println("1.��ǰ �� | 2.��ǰ �� �����Է� | 3.��ǰ�� ���� | 4.�м� | 5.����");
			System.out.println("�Է�>");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			// 2) �Է��� ��ǰ ����ŭ ��ǰ��� �ش� ������ �Է¹��� �� �ֵ��� �����ϼ���.
			if(selectNo == 1) {
				System.out.println("��ǰ �� �Է�>");
				pdutCount = Integer.parseInt(sc.nextLine());								
			} else if(selectNo == 2) {
				//�迭�� ũ��(��ǰ �����͸� ���� �� �ִ� ũ�� ����)
				pductArr = new Product[pdutCount];
				for(int i=0; i < pductArr.length; i++) {
					pductArr[i] = new Product();
					
					System.out.println("��ǰ��>");
					String productName = sc.nextLine();
					pductArr[i].productName = productName;
					
					System.out.println("����>");
					int price = Integer.parseInt(sc.nextLine());
					pductArr[i].price = price;
				}
				
			// 3) ��ǰ�� ������ ����ϼ���.
			//	��¿���, "��ǰ�� : ����"
			} else if(selectNo == 3) {
				for(int i=0; i < pductArr.length; i++) {
					System.out.println(pductArr[i].productName + " : " + pductArr[i].price + "��");
				}
			// 4) �м������ �ְ� ������ ������ ��ǰ�� �ش� ��ǰ�� ������ ��ǰ���� ������ ���մϴ�.
			} else if(selectNo == 4) {
				int maxPrice = pductArr[0].price;
				String maxProduct = pductArr[0].productName;
				for(int i=0; i < pductArr.length; i++) {
					if(pductArr[i].price > maxPrice) {
						maxPrice = pductArr[i].price;
						maxProduct = pductArr[i].productName;
					}
				}
				int sumPrice = 0;
				for(int i=0; i < pductArr.length; i++) {
					sumPrice += pductArr[i].price;
				}
				System.out.println("�ְ� ���� ��ǰ : " + maxProduct);
				System.out.println("�ְ� ���� ��ǰ�� ������ ��ǰ���� ���� ���� : " + sumPrice + "��");
				
			// 5) ���� �ÿ��� ���α׷��� �����Ѵٰ� �޼����� ����ϵ��� �����ϼ���.	
			} else if(selectNo == 5) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
