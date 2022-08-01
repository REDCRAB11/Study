package random;

import java.util.Random;

public class Test08 {

	public static void main(String[] args) {
		
		//확률 구현하기 
		// - 랜덤은 범위 내의 값이 동일한 확률로 나온다. 
		// - 일정 개수의 숫자 범위 내에서 원하는 개수를 지정하여 검사 
		// ex, 100개의 숫자 중 2개를 정하면 2%
		
		
		Random r = new Random();
		
		int range = r.nextInt(100) + 1;
		System.out.println("range = " + range);
		if(range <= 5) {
			System.out.println("당첨!");
		}else {
			System.out.println("꽝");
		}

	}

}
