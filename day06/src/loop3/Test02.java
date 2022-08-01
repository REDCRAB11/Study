package loop3;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		//while은 종료시점을 알 때 유용하게 사용할 수 있다. 
		
		//ex, 사용자가 0을 입력할 때까지 숫자를 반복적으로 입력받는 프로그램 
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("입력: ");
			int number = sc.nextInt();
			
			if(number == 0) {
				break; // 구문 탈출 명령 
			}
			
		}
		
		sc.close();
		
	}

}
