package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test02 {

	public static void main(String[] args) {
		// Calendar의 장점  - 시간 설정 
		// - 연도 설정이 Date보다 편하다(월은 그대로)
		// - 일자가 벗어나도 자동 계산된다. ex,, date=35면 알아서 넘어감..
		// - 윤년 등이 자동으로 계산된다. 
		
		Calendar c = Calendar.getInstance();
		
		// 설정 
//		c.set(Calendar.YEAR,2020);// 연도를 2020으로 설정
//		c.set(2020, Calendar.JANUARY, 1); 밑에랑 똑같은것 ..
//		c.set(2020, 0, 1); //(주의) 월은 1씩 차이가 난다 0~11로 지정. 
		
		int year =2020, month= 1, date =1;
		c.set(year, month-1, date); //month만 주의 하십셔 ㅋ 
		
		// 출력
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.format(d));
	}

}
