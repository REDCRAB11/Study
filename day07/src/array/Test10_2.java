package array;

import java.util.Random;
import java.util.Scanner;

public class Test10_2 {

	public static void main(String[] args) {
		
		//크키 설정 
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴개수: ");
		int size = sc.nextInt(); 
		
		//배열 생성
		String[]menu = new String[size];
		//menu.length == size
		
		//입력
		for(int i=0; i<size; i++) { //size번 반복문
			System.out.print("메뉴 입력: ");
			menu[i] =  sc.next(); //문자열은 next로만 받는다. 
		}
		sc.close();
		
		//랜덤위치 생성 
		Random r = new Random();
		int index = r.nextInt(size);
//		System.out.println("index = " + index);
		

		//출력 
		System.out.println("오늘 점심은 " + menu[index] + "갑시다.");
	}
}
