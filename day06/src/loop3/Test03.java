package loop3;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int C = 0;
		int B = 100;
		while(true) {
			
			System.out.println("숫자를 입력해 주세요.");
			int A = sc.nextInt();
//			System.out.println(B-A);
			B -=A;
		
			if(B < 0) {
			System.out.println("게임 종료");
			break;
			} else {
				C++;
			}
		}
		System.out.println("입력한 숫자 개수: " + C);
		
		sc.close();
	}

}
