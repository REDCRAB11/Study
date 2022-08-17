package api.util.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class Test04_3 {

	public static void main(String[] args) {
		// 준비 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("년도: ");
		int year = sc.nextInt();
		System.out.println("월: ");
		int month = sc.nextInt();
		
		// 계산
		// 1. 해당 월의 1일로 설정해서 무슨 요일인지 알아내야 한다. 
		// 2. 앞에 날짜를 몇 개 더 찍어야 하는지 알 수 있다.
		// - 1일이 일요일이면 앞에 출력할 글자가 0개
		// - 1일이 월요일이면 앞에 출력할 글자가 1개
		// - 1일이 화요일이면 앞에 출력할 글자가 2개 ....  
		// - 1일이 일요일이면 앞에 출력할 글자가 7개
		
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1); // 1번 코드 
		
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		c.add(Calendar.DATE, -(week-1)); // 2번에서 계산한 날짜 수 만큼 앞으로 이동하겠다. 
		
		// 출력
		System.out.println(year + "년" + month + "월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i=0; i<42; i++) {
			System.out.print(c.get(Calendar.DATE));
			System.out.print("\t");
			
			if(i % 7 ==6) {
				System.out.println();
			}
			
			c.add(Calendar.DATE, 1);
		}
		
	}
}
