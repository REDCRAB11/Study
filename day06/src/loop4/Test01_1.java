package loop4;

import java.util.Scanner;

public class Test01_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int score; 
		while(true) {
			System.out.println("점수: ");
			score = sc.nextInt();
			
			if(score >= 0 && score <= 100) {
				break;
			}
//			else {
//				System.out.println("다시 입력해 주세요.");
//			}
		}
		
		System.out.println("입력된 점수는 " + score + "점 입니다. ");
		sc.close();


		
		
		
	}

}