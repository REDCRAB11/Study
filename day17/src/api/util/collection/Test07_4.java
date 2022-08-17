package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test07_4 {
	public static void main(String[] args) {
		// 1부터 45까지를 6번 추첨하는 방법
		
		Random r = new Random();
		List<Integer> list = new ArrayList<>();
		
		
		for(int i=0; i<6; i++) {
			int number = r.nextInt(45)+1;
//			if(list.contains(number) == false) {// 한번도 뽑은적 없는 숫자라면
			if(list.contains(number)) {
				list.add(number);
			}
			else {
				i--; // 다시추첨 왜 --나면 위에 ++과 합쳐지면 0이되서 다시 돌아온다.
			}
		}
		Collections.sort(list);
		System.out.println(list);
//		System.out.println(list); 이거나 아래 둘 중 하나만 쓰셔 
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
	}
}
