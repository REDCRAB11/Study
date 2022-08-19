package api.util.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03_2 {
	public static void main(String[] args) {
		// 저장소 생성
		Map<String, Integer> history = new TreeMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("검색어: ");
			String keyword = sc.nextLine();
			
			int count;
			if(history.containsKey(keyword)) {
				count = history.get(keyword)+1;
				// count++;
			}else {
				count =1;
			}
			history.put(keyword, count);
			System.out.println("[" + keyword + "] 검색이 완료되었습니다. 현재 검색횟수 [" +history.get(keyword)+"]");
			
			System.out.println(history);
		}
//		sc.close();
	}
}
