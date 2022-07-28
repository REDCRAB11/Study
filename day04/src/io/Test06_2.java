package io;

import java.util.Scanner;

public class Test06_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 시각을 입력해 주세요:");
		int inH = sc.nextInt();
		int inM = sc.nextInt();
		System.out.print("종료 시각을 입력해 주세요:");
		int outH = sc.nextInt();
		int outM = sc.nextInt(); 
		sc.close();

		int pri = 1000;
		double priceM = pri / 60.0;
		int inTotal = inH * 60 + inM;  
		int outTotal = outH * 60 + outM;
		
		int total = outTotal - inTotal;
		
		double price = total * pri; 
		
		System.out.print("이용요금은:");
		System.out.println(price);
		
		
		System.out.println("//////////");
		
		
		
		//풀이 ~~ 
		
		
		//준비 
		int inHour = 16,  inMinute = 7;
		int outHour = 17,  outMinute = 15;
		
		int pricePerHour = 1000;
		
		
		//계산 
		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 +  outMinute; 
		int time = outTime - inTime;
		System.out.println("time = " + time);
		
		double pricePerMiute = pricePerHour / 60.0;
		
		int prices =(int)(time * pricePerMiute)/ 100*100; //10원단위 날리기 / 100 * 100 
		
		System.out.println("이용요금:" + prices +"원");
		
		
		//출력 
		
		
		
		
		
		
		
		
	}

}
