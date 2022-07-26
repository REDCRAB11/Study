package data;

public class Test10 {

	public static void main(String[] args) {
		//실수의 종류와 특징 
		//실수는 소수점이 있는 숫자 
		// - float  : 2^32(4byte, 32bit)
		// - double : 실수의 기본값, 2^64(8byte, 64bit)	
		
		float a = 1.5f; 
		double b = 1.5;
		
		System.out.println(a);
		System.out.println(b);
		
		
		// 1. 실수는 부정확하다.
		float c = 1.23456789123456789f;
		System.out.println(c);
		
		double d = 1.23456789123456789;
		System.out.println(d);
		
		
		// 2. 실수가 하나라도 포함된 계산은 결과가 실수가 나온다. 
		System.out.println(10/3); //정수-정
		System.out.println(10/3.0); //정수-실수
		System.out.println(10/3f); //정수-실수
		System.out.println(10/3d); //정수-실수
		
		
	}

}
