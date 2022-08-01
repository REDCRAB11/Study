package loop;

import java.util.Scanner;

public class Test14_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단수: ");
		int dan = sc.nextInt();
		
		//정답과 오답을 카운트하기 위한 변수를 생성.
		int correctCount = 0;
		int wrongCount =0;
		
		for(int i =1; i<=9; i++) {
			System.out.print(dan + " X " + i + " = ");
			int user = sc.nextInt();
			if(dan * i == user) {
				System.out.println("정답");
				correctCount++;
			}else {
				System.out.println("오답");
				wrongCount++;
			}
		}
		
		sc.close();
		System.out.println("게임 종료!");
		System.out.println("정답: " + correctCount + "개");
		System.out.println("오답: " + wrongCount + "개");

	}

}
