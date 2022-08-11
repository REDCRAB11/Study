package api.lang.String;

import java.util.Scanner;

public class Test02_1 {
	public static void main(String[] args) {
		
		//준비
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디: ");
		String userId = sc.next() ;
		System.out.println("비밀번호: ");
		String userPw = sc.next();
		sc.close();
		
		//계산
		boolean isLogin = userId.equals("khacademy") && userPw.equals("student");
//		boolean isLogin = userId == "khacademy" && userPw == "student";
		
		//출력
		if(isLogin == true) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 불가");
		}
	}
}
