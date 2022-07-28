package io;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		// 문자열 입력 
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("닉네임 입력");
		String nickname = sc.next();
		System.out.println("나이 입력");
		int age = sc.nextInt();
		sc.close();
		
		System.out.println("입력된 닉네임 " + nickname + " 입니다."); 
		System.out.println("나이는" +age+ " 입니다.");
		//띄어쓰기 하면 띄어쓴 부분 뒤에는 날라간다. ~ 
		
		
		
		

	}

}
