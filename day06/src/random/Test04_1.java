package random;

import java.util.Random;
import java.util.Scanner;

public class Test04_1 {

	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int life =3; //누적이 되어야해서 밖에 만듬 계속해서 관리해야하는 경우는 밖에다 만든다. 이를테면 카운트 
		int count = 0;

	
		while(true) {
		int a = r.nextInt(8) + 2;
		int b = r.nextInt(9) + 1;
		
		System.out.println(a + "X" + b + "=");
		
		int user = sc.nextInt();
		
		if(user == a * b) {
			System.out.println("정답");
			count++;
		}else {
//			System.out.println("오답");
			life--;
			System.out.println("남은 기회: " +life);
			if(life ==0) {//남은 life가 0이라면 탈출 
				break;
			}
		}
		}
		sc.close();
		System.out.println("게임오버");
		System.out.println("정답 개수: " + count);
	}

}
