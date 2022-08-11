package api.lang.String;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력해 주세요");
		String id = sc.next();
		System.out.println("비밀번호를 입력해 주세요");
		String pw = sc.next(); 

		String idd = "khacademy";
		String pww = "student";
		
		if(id == idd && pw == pww) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("아이디와 비밀번호를 다시 입력해 주세요");
		}
		
	}
	
	
	
}
