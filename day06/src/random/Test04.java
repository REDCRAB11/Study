package random;

import java.util.Random;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		// 사용자가 3번 틀릴 때까지 무작위로 구구단 문제를 출제하는 프로그램을 구현하세요
		//3번 틀리면 게임오버가 되며 그동안 맞춘 문제 개수가 출력되어야 합니다.


		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("게임 시작!");
		
		int total = 0; 
		int wrong = 3; 
		
		for(int i=1; i<10; i++) {

			int Gu = r.nextInt(9) + 1;
			System.out.println(Gu + "X" + i + "=");
			int U = sc.nextInt();
			int Cor = Gu * i;
			
			if(Cor == U) {
					System.out.println("정답");
					total++;
			}
			else{
				wrong--;
				System.out.println("남은 기회: " + wrong);
				System.out.println("게임 종료");
				if(wrong ==0) {
					break;
				}
			
			}
		}

		
		total++;
		sc.close();
		System.out.println("맞춘 문제 개수: " + total);
		
	}

}
