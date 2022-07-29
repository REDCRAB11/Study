package loop;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
//		int A = a.nextInt();
		int aloneCount = 0;
		int doubleCount = 0;

		for(int i=0; i<=10; i++) {
			
			System.out.print("숫자 입력: ");
			int A = sc.nextInt();
			
			if(A % 2 == 1) {
//				System.out.println("홀수");
				aloneCount++;
			}else {
//				System.out.println("짝수");
				doubleCount++;
			}
			
		}
		sc.close();
		
		System.out.println("홀수 개수: " + aloneCount);
		System.out.println("짝수 개수: " + doubleCount);
		
		
		
		
		
	}
}
