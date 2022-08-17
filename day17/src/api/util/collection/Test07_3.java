package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test07_3 {
	public static void main(String[] args) {
		// 1부터 45까지를 6번 추첨하는 방법
		
		Random r = new Random();
		List<Integer> list = new ArrayList<>();
		
		
		for(int i=0; i<6; i++) {
			int number = r.nextInt(45)+1;
			list.add(number);
		}
		Collections.sort(list);
//		System.out.println(list); 아래 혹은  이거나 둘 중 하나만 쓰셔 
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
