package random;

import java.util.Random;
import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
//		업다운 게임
//
//		숫자를 하나 정해두고 이를 맞추는 게임을 업다운 게임이라고 합니다.
//
//		프로그램이 랜덤으로 1에서 1000 사이의 숫자를 하나 정합니다.
//		사용자가 범위 내에서 숫자를 입력합니다.
//		프로그램은 사용자가 입력한 값과 정답을 비교해서 업, 다운, 정답 세 개중 하나를 알려줍니다.
//		업은 정답이 입력값보다 크다는 의미입니다.
//		다운은 정답이 입력값보다 작다는 의미입니다.
//		정답은 정답과 입력값이 같은 경우를 말하며, 게임이 종료되어야 합니다.
//		업다운 게임을 구현하시고 정답을 맞추면 몇번 만에 맞췄는지 계산해서 출력해주세요.
		
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		while(true){
		int B = sc.nextInt();
		System.out.println("사용자:" + B);
		
		
		int A = r.nextInt(1000) +1;
		System.out.println("랜덤:" + A);
		
		int total = 0;
		if(A == B) {
			System.out.println("정답. 게임 종료");
			total++;
			System.out.println("total: " + total);
		}else if(A <= B) {
			System.out.println("업");
		}else{
			System.out.println("다운");
		}
		}
				
	}

}
