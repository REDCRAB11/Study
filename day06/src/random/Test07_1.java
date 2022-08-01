package random;

import java.util.Random;
import java.util.Scanner;

public class Test07_1 {

	public static void main(String[] args) {
		
		
		//1회 업다운 게임 
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
	
		//정답 생성
		int com = r.nextInt(1000) + 1;	
		System.out.println("com: " + com);
		 
		//사용자 입력 
		System.out.print("입력: ");
		int user = sc.nextInt();
		
		// 판정
		if(com > user) {
			System.out.println("UP");
		}else if( com < user) {
			System.out.println("Down");
		}else {
			System.out.println("Correct!");
		}
		
		
		sc.close();

	}

}
