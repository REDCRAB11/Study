package api.util.collection;

import java.util.Random;

public class Test07_2 {
	public static void main(String[] args) {
		// 1부터 45까지를 6번 추첨하는 방법
		
		Random r = new Random();
		for(int i=0; i<6; i++) {
			int number = r.nextInt(45)+1;
			System.out.println("number = " + number);
		}
	}
}
