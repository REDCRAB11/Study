package oop.keyword10;

import java.util.Random;

public class Test04 {
	
	public static void main(String[] args) {
		
		//동전 던지기 
		Random r = new Random();
		int coin = r.nextInt(2); 
		if(coin == Coin.FRONT) {
			System.out.println("앞");
		}else {
			System.out.println("뒤");
		}
		
		
	}

}
