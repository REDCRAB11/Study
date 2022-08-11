package api.lang.String;

import java.util.Scanner;

public class Test02_2 {
	public static void main(String[] args) { // 객체지향으로 풀어보기 ~~ 
		
		//준비
		
		Member admin = new Member("khacademy", "studnet");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디: ");
		String userId = sc.next() ;
		System.out.println("비밀번호: ");
		String userPw = sc.next();
		sc.close();
		
		Member user = new Member(userId, userPw);
		
		//계산
		boolean isLogin = admin.equals(user);
		
		//출력
		if(isLogin) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 불가");
		}
	}
}
