package api.util.calendar;

import java.security.SignatureException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
		//Calendar 클래스 
		// - 추상 클래스라 객체 생성이 불가능하다.  
		// Calendar c = new Calendar(); 직접 생성 어차피 근데 안됨..ㅋ 
		
		Calendar c = Calendar.getInstance(); // 생성 메소드(환경 분석 후 생성)  
		System.out.println(c);
		
		// 정보가 다 필요한 것이 아니므로 원하는 형태만 뽑을 수 있어야 한다. 
		// 1. Date로 변환한 뒤 출력 
		// 2. 직접 원하는 정보를 꺼내어 출력 

		//1
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.format(d));
		
		//2
//		int year = c.get(1); 
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1; // 컴퓨터는 0~11까지의 월만 나오기 때문에 현재 월(Month) -1
//		int day = c.get(Calendar.DATE);
		int day = c.get(Calendar.DAY_OF_MONTH);
//		int hour = c.get(Calendar.HOUR); // 12시간 방식
		int hour = c.get(Calendar.HOUR_OF_DAY);
//		(참고) 요일 일요일-1 , 월요일-2, 화요일-3, .. 토요일-7 
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("year = " + year);
		System.out.println("month = " + month);
		System.out.println("day = " + day);
		System.out.println("hour = " + hour);
		System.out.println("week = " + week);
	}

}
