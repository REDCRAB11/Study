package api.util.scanner;

import java.util.Scanner;

public class Test01_1 {

	public static void main(String[] args) {	
		String origin = "학교종이 땡땡땡 어서모여라 \n 선생님이 우리를 기다리신다.";
		Scanner sc = new Scanner(origin);
//		
//		while(true) {
//			if(sc.hasNext() == false) {
//				break;
//			}
//			System.out.println(sc.next());
//		}
		while(sc.hasNext()) { // == true는 생량해도 ㅇㅋ
			System.out.println(sc.next());
		}
		sc.close();
	}

}
