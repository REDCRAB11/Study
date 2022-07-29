package condition2;
import java.lang.*;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {

		// 사용자에게 연도와 월을 입력 받아서 날짜 수를 구하는 프로그램 구현 
		// 윤년은 다음과 같은 규칙에 의해 정해진다
		// 연도가 4의 배수면 윤년 2020, 2024, 2028 윤년 ,, 4의 배수지만 100의 배수면 윤년이 아니다. 2100년은 윤년이 아니다. 
		// 400의 배수면 윤년 2000년은 윤년. 
		// 연도 월 별 입력하면 며칠까지 잇다. 2월 구하는게 중요스.
		
		
		Scanner a = new Scanner(System.in);
		System.out.println("연도를 입력하세요.");
		int year = a.nextInt(); 
		
		System.out.println("월을 입력하세요.");
		
		int month = a.nextInt(); 
	
		int day;
		switch(month) {
		case 2:
		if( year % 4 == 0 && year % 400 == 0 || year % 100 == 0) {
			System.out.println("29일");		
		}
		else {
			System.out.println("28일");
		}
		break;
		
		case 4: case 6: case 9: case 11:
			System.out.println("30일");
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31일");
			break;
		}
		a.close();
		

	}

}
