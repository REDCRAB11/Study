package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		
		// 저장소 생성 
		//String [] list = new String[5];
		List<String> list = new ArrayList<>();
		
		list.add("자바");
		list.add("파이썬");
		list.add("루비");
		list.add("안드로이드");
		list.add("자바스크립트");
		
//		System.out.println(list);
		Random r = new Random();
		int index = r.nextInt(5); 
		
		System.out.println(list.get(index));
		
	
	}

}
