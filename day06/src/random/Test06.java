package random;

import java.util.Random;

public class Test06 {

	public static void main(String[] args) {
		// 부루마블이라는 게임을 하다가 무인도에 갇혔습니다.
    
		//무인도에서 탈출하려면 주사위 두 개를 던져서 5-5가 나오거나 6-6이 나와야 합니다.

		//무인도에서 탈출할 때까지 주사위를 던지고, 탈출하면 던진 주사위 횟수가 출력되도록 구현하세요.


		Random r = new Random();
		int total = 0;
		

		while(true) {
			int dice = r.nextInt(6) + 1;
			int dice2 = r.nextInt(6) + 1;	
			System.out.println("dice= " + dice + " dice2= " + dice2);
			total++;
	    if((dice == 5 && dice2 == 5) || (dice == 6 && dice2 ==6)){
	    	System.out.println("탈출 성공!");
	    	System.out.println("총" + total + "번");
	    	break;
		}
		}
	
	
		
		// 5-5 6-6 어떻게 표현하지..
	}
}
