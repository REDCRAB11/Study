package random;

import java.util.Random;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
//		
//		랜덤으로 구구단 문제를 하나 출제하고 사용자가 정답을 입력하면 정답과 오답을 판정하는 프로그램을 구현하세요
//
//		단, 문제는 2x1부터 9x9의 범위 내에서 출제해야 합니다

		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단 게임을 시작합니다.");
		
		
		int Gu = r.nextInt(9) + 2;
		for(int i=1; i<10; i++) {
			System.out.println(Gu + "X" + i + "=");
			int U = sc.nextInt();
			if(Gu * i == U) {
				System.out.println("정답");
			}else {
				System.out.println("오답");
			}
		}
		sc.close();
	}

}
