package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test03 {

	public static void main(String[] args) {
		// 주요 명령 
		List<String> list = new ArrayList<>();
		
		// 추가 
		list.add("누룽지");
		list.add("맛있어");
		list.add("찹쌀떡");
		list.add("그냥그래");
		list.add("졸려");
		
		// 검색
		// Q. 누룽지가 list에 있습니까?
		System.out.println(list.contains("누룽지")); // 있으니깐 true 
		System.out.println(list.indexOf("졸려")); // 자리(위치) 몇번째? 
		
		// Q. 2번 위치에 들어있는 것은 무엇입니까?
		System.out.println(list.get(2));
		
		// Q. 누룽지 제거 
		list.remove("누룽지");
		
		
		System.out.println(list);
		System.out.println(list.isEmpty()); // 비어있는가? 
		System.out.println(list.size()); // 데이터가 몇개있어요? 
	}

}
