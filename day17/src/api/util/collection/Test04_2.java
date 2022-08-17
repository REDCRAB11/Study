package api.util.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test04_2 {
	public static void main(String[] args) {
		
		// 저장소 생성 
		// - 배열처럼 한번에 데이터까지 초기화하면서 생
		//String [] list = new String[5];
		
		// 자바 8~ 일때만 사용 가능..
//		List<String> list = Arrays.asList("자바","파이썬", "루비", "안드로이드","자바스크립트");
		
		// 자바 9~
		List<String> list = List.of("자바","파이썬", "루비", "안드로이드","자바스크립트");
		
//		System.out.println(list);
		Random r = new Random();
		int index = r.nextInt(5); 
		
		System.out.println(list.get(index));
		
	
	}

}
