package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> login = new HashMap<>();
		
		System.out.print("ID: ");
		String id = sc.next();
		System.out.print("PW: ");
		String pw = sc.next();
		
		login.put(id, pw);
		
		login.put("testuser", "testuser1234");
		login.put("student", "student1234");
		login.put("manager", "manager1234");
		
		if(login.containsKey(id) == login.containsValue(pw) ) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
}
