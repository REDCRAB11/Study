package api.util.scanner;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {	
		String origin = "학교종이 땡땡땡 어서모여라 \n 선생님이 우리를 기다리신다.";
		Scanner sc = new Scanner(origin);
		
		// .nextLine(): 줄바꿈(\n) 전까지 읽는 명령 (엔터에만 반응함!!!)
		// .hasNextLine() : 줄 읽기가 가능한지 확인하는 명령 
//		
//		System.out.println(sc.nextLine());
//		System.out.println(sc.nextLine());
//		System.out.println(sc.nextLine()); // 오류남 .. 
// 		밑에처럼 줄여서 쓸 수 있따.! 		
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
	}

}
