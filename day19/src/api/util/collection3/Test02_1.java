package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02_1 {
	public static void main(String[] args) {
		// 저장소 생성 및 데이터 준비 	
		Scanner sc = new Scanner(System.in);
		Map<String, String> login = new HashMap<>();
		
		login.put("testuser", "testuser1234");
		login.put("student", "student1234");
		login.put("manager", "manager1234");
		
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		sc.close();

		boolean isLogin = login.containsKey(id) && pw.equals(login.get(id));
//		boolean isLogin = login.get(id) != null && login.get(id).equals(pw); 이것도 같은 말 ~ 근데 추천하지는 않음 
		
		if(isLogin) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
}
