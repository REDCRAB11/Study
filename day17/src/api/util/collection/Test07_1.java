package api.util.collection;

import java.util.Random;

public class Test07_1 {
	public static void main(String[] args) {
		// 1부터 45까지를 6번 추첨하는 방법
		
		Random r = new Random();
		int number = r.nextInt(45)+1;
		System.out.println("number = " + number);
	}
}
