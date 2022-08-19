package api.util.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03_4 {
	public static void main(String[] args) {
		// 저장소 생성
		Map<String, Integer> history = new TreeMap<>();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("검색어: ");
			String keyword = sc.nextLine();
			keyword = keyword.toLowerCase(); //소문자 변환 
//			keyword = keyword.trim(); // 좌우로 불필요한 여백 제거 
			keyword = keyword.replace(" ", "");
			
			if(keyword.equals("종료")) {
				break;
			}
			
			int count;
			if(history.containsKey(keyword)) {
				count = history.get(keyword)+1;
				// count++;
			}else {
				count =1;
			}
			history.put(keyword, count);
			System.out.println("[" + keyword + "] 검색이 완료되었습니다. 현재 검색횟수 [" +history.get(keyword)+"]");
			
//			System.out.println(history);
		}
		sc.close();
		System.out.println("프로그램 종료");
		
	}
}
