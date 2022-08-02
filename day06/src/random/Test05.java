package random;

import java.util.Random;

public class Test05 {

	public static void main(String[] args) {
		
//		주사위를 100번 던졌을 때 홀수와 짝수가 각각 몇 번씩 나오는지 계산하여 출력하ㅔㅅ요

		Random r = new Random();
		

		int oddCount = 0;
		int evenCount = 0;
		
		for(int i=1; i<=100; i++) {
		int dice =  r.nextInt(6) + 1;
		if(dice % 2 == 0 ) {
//			System.out.println("짝");
			oddCount++;
		}else {
//			System.out.println("홀");
			evenCount++;
		}
		}
		
		System.out.println("짝수 개수: " + oddCount);
		System.out.println("홀수 개수: " + evenCount);
		
	}

}