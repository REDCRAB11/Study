package array;

import java.util.Random;
import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
//		점심 메뉴 추첨 프로그램
//
//		사용자에게 입력할 메뉴의 개수를 입력받아 해당 크기만큼의 배열을 생성합니다
//		생성된 배열에 점심메뉴를 입력합니다
//		입력이 완료되면 입력된 메뉴 중에서 랜덤으로 한 개의 메뉴를 추첨한 뒤 출력합니다

	

		Scanner sc = new Scanner(System.in);
		System.out.println("개수: ");
		int size = sc.nextInt(); 
		
		String[]menu = new String[size];
		
		for(int i=0; i<size; i++) {
			System.out.println("메뉴 입력: ");
			menu[i] = sc.next();
		}
		sc.close();
		
		Random r = new Random();
		int index = r.nextInt(size);
		
		System.out.println("오늘 점심은 " + menu[index] + "입니다. ");
		
		
		
	}
	}

