package oop.keyword9;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	System.out.print("아이디: ");
	String id = sc.next();		// final 앞에 붙이기도 함 
			
	System.out.print("비밀번호: ");
	String pass = sc.next();
	
	System.out.print("닉네임: ");
	String nick = sc.next();
	
	sc.close();
			
	Leap a = new Leap(id, pass, nick );
	a.vet();
	}

}
