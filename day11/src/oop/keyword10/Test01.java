package oop.keyword10;

import java.util.Random;

public class Test01 {
	// 외부에서 부를 수 있도록 필드로 선언한다.  final 그리고 main 위로 올려버려 1
	// - 객체 없이 편하게 부르라고 static처리 ,, 변경 없으니 안전하게 쓰라고 final 처리  static 2
	// - 접근제한도 퍼블릭으로 설정한다. = public 3
	// - 상수(constant)라고 부른다 = public static final 을 .. 
	public	static final int FRONT = 0, BACK = 1;  
	// (약속)(0: 앞 || 1: 뒤 )
	
	public static void main(String[] args) {
		
		//동전 던지기 
		Random r = new Random();
		int coin = r.nextInt(2); 
		if(coin == FRONT) {
			System.out.println("앞");
		}else {
			System.out.println("뒤");
		}
		
		
	}

}
