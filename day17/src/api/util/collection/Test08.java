package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("인원 수: ");
		
		int people = sc.nextInt();
		sc.nextLine();
		
		List<String > list = new ArrayList<>();
		
		for(int i=0; i<people; i++) {
			System.out.print("이름: ");
			list.add(sc.nextLine());
		}
		
		List<String> win = new ArrayList<>();
		
		for(int i=0; i<people; i++) {
			System.out.print("항목: ");
			win.add(sc.nextLine());
		}
		
		sc.close();
		
		Collections.shuffle(win);
		
		for(int i=0; i<people; i++) {
			System.out.println(list.get(i) + " - > " + win.get(i));
		}
		
		
		
		
		
	}

}
