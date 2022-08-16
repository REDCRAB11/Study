package api.util.date;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test03 {

	public static void main(String[] args) {
		
		// 우리나라는 ~ H: 24시간 기준 h: 12시간 기준(오전, 오후기준 눴을떄는) !! 
		Date a = new Date();

//		SimpleDateFormat f = new SimpleDateFormat("y년 M월 d일 E");
		Format f = new SimpleDateFormat("y년 M월 d일 E"); // up-casting 해서.. 
		System.out.println(f.format(a));
		
		SimpleDateFormat f2 = new SimpleDateFormat("a h시 m분 ");
		System.out.println(f2.format(a));
		
		SimpleDateFormat f3 = new SimpleDateFormat("HH:mm:ss");
		System.out.println(f3.format(a));
		
		SimpleDateFormat f4 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");
		System.out.println(f4.format(a));
	}

}
