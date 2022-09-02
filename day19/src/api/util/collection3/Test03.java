package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03 {
	public static void main(String[] args) {
		Map<String, String> search = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("검색어 입력: ");
			String a = sc.nextLine();
			sc.nextLine();
			int count =0;
			if(search == search) {
				count++;
				System.out.println("["+a+"]"+"검색이 완료되었습니다." + "현재 겸색횟수 [" + count + "]");
			}
		}
		
	}
}
