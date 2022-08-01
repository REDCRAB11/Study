package loop4;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// do ~ while 반복문 
		// - 사용빈도가 매우 낮음 
		// - 선 실행 후 검사 
		
		// ex, 0부터 100 사이의 숫자(올바른 점수)가 입력되면 종료하는 반복문 
		
		Scanner sc = new Scanner(System.in);
		
		int score;
		do {
           System.out.print("점수: ");
           score = sc.nextInt();
		}
		while(score < 0 || score >100);
//		while(잘못 입력하면); 
		System.out.println("입력된 점수는 " + score + "점 입니다. ");
		sc.close();

		
//		
//		while문으로 바꿨을 때 
//		int score;
//		while(true);
//		{
//			System.out.println("점수: ");
//			score = sc.nextInt();
//			if( score >= 0 && score <= 100) {
//				break;
//			}
//		} 
//	      System.out.println("입력된 점수는 " + score + "점 입니다. ");
//		
//	      	sc.close();
//		
		
		
		
	}

}
