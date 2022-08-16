package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {

	public static void main(String[] args) {
		// Date의 형식(format) 바꾸기  
		// - java.text.SimpleDateFormat 클래스를 사용하면 형식을 바꿀 수 있다. 
		
		Date a = new Date();
		System.out.println(a);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.format(a));

		SimpleDateFormat f2 = new SimpleDateFormat("y년 M월 d일");
		System.out.println(f2.format(a));
		
	}

}
