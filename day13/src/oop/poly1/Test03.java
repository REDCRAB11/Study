package oop.poly1;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		// 랜덤으로 휴대폰 1개를 만들어서 통화 기능을 실행
		//(약속) 0 : 갤럭시 폴드 3 , 1: 아이폰 13 
		
		Random r = new Random();
		int choice = r.nextInt(2);
		
		Phone phone;
		if(choice == 0) {
			phone = new GalaxyFold3(); // 갤럭시폴드3 ----> 폰 (업캐스팅)
		}
		else {
			phone = new IPhone13(); // 아이폰13 ----> 폰 (업캐스팅)			
		}
		phone.call();
	}

}
