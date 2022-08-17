package api.util.scanner;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		// 키보드 입력에서의 문제상황 
		// - .next() 계열의 명령 사용 후 .nextLine()을 사용하면 입력이 안된다. 
		// - 왜냐? 남아있는 \n(엔터)때문 
		// - 남아있는 \n을 제거하면 입력이 가능하다. 
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next(); // 사용자의 입력값 중에서 공백 전까지 입력받아 저장 
		
		sc.nextLine(); // 남아있는 \n을 제거하는 방법 ( next -> nextLine 할때만.. )
		
		String b = sc.nextLine(); // 사용자의 입력값 중에서 \n 전까지 입력받아 저장 
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		sc.close();
		
	}

}
