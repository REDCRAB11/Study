package io;

import java.util.Scanner;

public class Test06_1 {

	public static void main(String[] args) {
		
		//풀이1 ~~ 
		
		
		//준비 
		Scanner sc = new Scanner(System.in);
		System.out.println("시작시각 입력");
		int in = sc.nextInt();
		System.out.println("종료시각 입력");
		int out = sc.nextInt();
		sc.close();
		
		int inHour = in /100, inMinute = in % 100;
		int outHour = out / 100,  outMinute = out % 100;
		
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
