package io;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		//준비 
		
		int jja = 5000;
		int pong = 6000; 
		
		//손님이 정하는 정보(입력)
		Scanner sc = new Scanner(System.in);
		System.out.println("자장면 개수를 입력하세요.");
		int jjaCount = sc.nextInt(); 
		System.out.println("짬뽕 개수를 입력하세요.");
		int pongCount = sc.nextInt();
		sc.close();
		
		//계산 
		int jjaTotal = jja * jjaCount; 
		int pongTotal = pong * pongCount; 
		int total = jjaTotal + pongTotal; 
		
		//출력
		System.out.println("결제금액:" + total + "원");

		
	}

}
