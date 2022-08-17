package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test07_01 {
	public static void main(String[] args) {
		// 2. 1~45를 저장하고 섞은 뒤 6개를 추첨하는 방법 
		
		List<Integer> list = new ArrayList<>();

		for(int i=1; i<=45; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list); // 이렇게 하면 중복은 안나온다 ~ 
		
		//list의 앞 6개를 초이스에 옮겨서 정렬 후 출력
		
//		List<Integer> choice = list.subList(0, 6);  이거나 밑에거 둘 중 하나 사용 하에쇼 
		List<Integer> choice = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			choice.add(list.get(i));
		}
		Collections.sort(choice);
		for(int i=0; i<choice.size(); i++) {
			System.out.println(choice.get(i));
		}
	}
}
