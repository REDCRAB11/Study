package api.lang.objects;

import java.util.Random;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		// Object는 모든 데이터의 최상위 클래스다.
		// => 다형성의 최고 정점에 있다. 
		// => 아무거나 저장 가능하다. 
		
		Object a = "hello!";
		Object b = 10;
		Object c = 2.13;
		Object d = true;
		Object arr = new int[5];
		Object r = new Random();
		Object sc = new Scanner(System.in);
		
		//Object 상태에서는 고유 기능을 사용할 수 없다. 
		// => 하지만 어떤 형태인지 검사는 가능하다. 
		System.out.println(a.getClass());
		System.out.println(b.getClass());
		
		
		//Q. a는 String 형태 인가요? (우리가 궁금한 것은..) => true/false 로 나온다 
		System.out.println(a instanceof String);
		System.out.println(a instanceof Random);
		
		//Q. 내가 만든 클래스도 오브젝트의 자식인가?
		Object s = new Student();
		
	}
}
