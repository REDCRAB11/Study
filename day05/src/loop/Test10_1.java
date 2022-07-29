package loop;

import java.util.Scanner;

public class Test10_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int oddCount =0;
		int evenCount =0;
		
		
		for(int i=0; i<=10; i++) {
			System.out.print("숫자입력: ");
			int a = sc.nextInt();
			
			
			if(a % 2 ==1) {
//				System.out.println("홀수");
				oddCount++;
			}
			else {
//			    System.out.println("짝수");
			    evenCount++;
			}
		
		}
		sc.close();
		System.out.println("홀수 개수: " + oddCount);
		System.out.println("짝수 개수: " + evenCount);
	
		

	}

}
