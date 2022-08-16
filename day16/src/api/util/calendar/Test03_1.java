package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03_1 {

	public static void main(String[] args) {
		// 기념일 관리 프로그램 
		Calendar c = Calendar.getInstance();
		
		// 계산
//		c.set(Calendar.DATE, 오늘날짜+99);
//		c.set(Calendar.DATE, date+99); 밑에랑 같음
//		c.add(Calendar.DATE, +99);			
		
		Format f = new SimpleDateFormat("y년 M월 d일 E요일");
		c.add(Calendar.DATE, -1);
		for(int i=100; i <=1000; i+=100) {
			c.add(Calendar.DATE, 100);
		}
		
		//출력
		Date d = c.getTime();
		System.out.println("100일 - " + f.format(d));
		
		
	}

}
