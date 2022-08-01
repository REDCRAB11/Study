package random;

import java.util.Random;

public class Test01 {

	public static void main(String[] args) {
		//랜덤(Random)
		// - 무엇이 나올지 예측이 되지 않는 값
		// - 주사위, 로또, 아이템 뽑기....
		// - 확률적인 형태가 구현 가능함 
		// - 구현 방법은 여러 가지가 있다. 
		// 1. Math.random() 명령 사용 
		// 2. Random 도구 사용 
		// 3. SecureRandom 도구 사용 
		
		//1. Math.random() 명령은 0 이상 1 미만의 double를 무작위로 만드는 명령 
//		System.out.println(Math.random());
		
		double a = Math.random();
		double b = a * 10;
		int c = (int)b;
		int d = c + 1;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
//		System.out.println("a = " + a);
		//공식 유도 
		
//		double a = Math.random();
//		double b = a * 10;
//		int c = (int)b;
		int number =(int)(Math.random()*10/*개*/)+1/*부터*/; // 1~10
		System.out.println("number = " + number);
	
	
		
		//2. Random 도구 사용해서 값 생성 
		// 랜덤은 close()가 없다. 입출력에서만 나온다. 
		Random r = new Random();
		
		int number2 = r.nextInt(10/*개*/) + 1/*부터*/;
		System.out.println("number2 = "+  number2);
	
	}

}
