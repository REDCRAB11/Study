package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05_1 {

	public static void main(String[] args) {
		// 기억력 게임
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
	
		System.out.println("나라 이름 입력 시작!");
		
		while(true) {
			System.out.print("나라이름: ");
			String name = sc.nextLine();
			
			if(list.contains(name)) { // 이미 들어있는 데이터라면(또 입력했다면..)
				break;
			}else { // 처음 입력했다면.
				list.add(name);
//				System.out.println(list);
//				System.out.println(list.size());
			}
			
		}
		
		sc.close();
		System.out.println("게임오버!");
		// 나라 이름 출력(=list 전체 출력)
		for(int i=0; i <list.size(); i++) {
			System.out.print(list.get(i) + "->" );
		}
	}

}
