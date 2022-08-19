package api.util.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test03_1 {
	public static void main(String[] args) {
		// 저장소 생성
		Map<String, Integer> history = new TreeMap<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어: ");
		String keyword = sc.nextLine();
		
		history.put(keyword, 1);
		System.out.println("[" + keyword + "] 검색이 완료되었습니다. 현재 검색횟수 [" +history.get(keyword)+"]");
		
		sc.close();
	}
}
