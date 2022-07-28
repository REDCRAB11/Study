package io;

public class Test01 {

	public static void main(String[] args) {
		// I/O - Input/Output, 입출력 
		//표준 출력 - system.out 을 이용하여 글자를 내보내는 행위 
		//표준 입력 - system.in 을 이용하여 글자를 받아들이는 행위 
		
		//system.out.println()은 화면에 글자를 내보내고 줄을(한줄로) 바꾸는 명령
		System.out.println("Hello");
		System.out.println("Hello");
		
		
		//system.out.print()는 화면에 글자를 내보내는 명령 
		System.out.print("Hello");
		System.out.print("Hello");
		System.out.println("\n");
		
		//system.out.printf()는 C언어 개발자를 위해 만든 출력 명령 
		System.out.printf("%d + %d = %d\n", 10,20,30);

		
}
}
