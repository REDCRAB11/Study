package random;

import java.util.Random;
import java.util.Scanner;

public class Test07_2 {

	public static void main(String[] args) {
		
		
		//1회 업다운 게임 
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
	
		//정답 생성
		int com = r.nextInt(1000) + 1;	
//		System.out.println("com: " + com);
		
		int count = 0;
		
		while(true) {
		 
		//사용자 입력 
		System.out.print("입력: ");
		int user = sc.nextInt();
		
		count++; //모든 경우에 다 증가 
		
		// 판정
		if(com > user) {
			System.out.println("UP");
		}else if( com < user) {
			System.out.println("Down");
		}else {
			System.out.println("Correct!");
//			System.out.println("총 " + count + "번 만에 맞췄습니다."); 여기에 만들어도 실행은 된다.. 그치만 밑에 놓는게 낫긴함 
			break;
		}
		}		
		
		sc.close();
		System.out.println("총 " + count + "번 만에 맞췄습니다.");
		

	}

}
