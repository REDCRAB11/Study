package api.util.scanner;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {	
		String origin = "학교종이 땡땡땡 어서모여라 \n 선생님이 우리를 기다리신다.";
		Scanner sc = new Scanner(origin);
		
		// .next(): 단어(공백 전까지) 
		// . hasNext(): 읽을 수 있는 단어가 있는지 확인하는 명령 
		System.out.println(sc.hasNext()); // true: 읽을 것이 있다. 
		System.out.println(sc.next()); 
		System.out.println(sc.hasNext());
		System.out.println(sc.next()); 
		System.out.println(sc.hasNext());
		System.out.println(sc.next()); 
		System.out.println(sc.hasNext());
		System.out.println(sc.next()); 
		System.out.println(sc.hasNext());
		System.out.println(sc.next()); 
		System.out.println(sc.hasNext());
		System.out.println(sc.next()); 
		System.out.println(sc.hasNext()); // false: 읽을 것이 없다.
		System.out.println(sc.next()); // 읽을게 없으면 오류남 ~  

		
	}

}
