package random;

import java.util.Random;

public class Test05_1 {

	public static void main(String[] args) {
		Random r = new Random();
	
		int oddcount = 0 , evencount =0;
		
		for(int i=0; i<100; i++) {
		
		int dice = r.nextInt(6) + 1;
//		System.out.println("주사위: " + dice);
		
		
		if(dice % 2 !=0) {
//			System.out.println("홀수");
			oddcount++;
		}else {
//			System.out.println("짝수");
			evencount++;
		}
		}
		
		System.out.println("홀수: " + oddcount + "번");
		System.out.println("짝수: " + evencount + "번");
	
	}

}
