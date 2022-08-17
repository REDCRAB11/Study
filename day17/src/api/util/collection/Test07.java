package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {
		// 2. 1~45를 저장하고 섞은 뒤 6개를 추첨하는 방법 
		
		List<Integer> list = new ArrayList<>();

		for(int i=1; i<=45; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list); // 이렇게 하면 중복은 안나온다 ~ 
		
		for(int i=0; i<6; i++) {
			System.out.println(list.get(i));
			Collections.sort(list);
		}
	}
}
