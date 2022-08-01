package loop3;

import java.util.Scanner;

public class Test03_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int total = 100;
		int Count = 0;
		while(true) {
		
		System.out.print("숫자 입력: ");
		int num = sc.nextInt();
		
		total -= num;
//		System.out.println("total: " + total);
		
		if(total < 0) {
			break;
		} else {
			Count++; // 카운트는 어디에 놓느냐에 따라 세는 개수가 달라질 수 있다. 
		}
		
	}
		
		sc.close();
		System.out.println("게임 종료");
		System.out.println("총 " + Count +"번 입력 하셨습니다. ");
	}

}
