package api.util.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) throws Exception {
		
		Calendar c = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연도: ");
		int year = sc.nextInt();
		System.out.println("월: ");
		int month = sc.nextInt();
		
		if(month<1 || month >12) {
			System.out.println("1~12 사이의 숫자를 입력해주세요.");
			throw new Exception();
		}
		
		sc.close();
		
		System.out.println("연도: " + year + "\n" + "월: " + month);
		System.out.print("일\t월\t화\t수\t목\t금\t토");
		System.out.println("\t");
		
		c.set(year, month-1,1);
		
		int last = c.get(Calendar.DAY_OF_WEEK);
		c.add(Calendar.DATE,-(last-1));
	
		
		int count=0;
		for(int i=0; i<42; i++) {
			System.out.print(c.get(Calendar.DATE));
			System.out.print("\t");
			c.add(Calendar.DATE, 1);
			count++;
			if(count % 7 == 0) {
				System.out.println();
			}
		}
	}
}
