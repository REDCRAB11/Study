package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("인원 수: ");
		int people =3; //인원수(반복횟수)
		
		List<String> names = new ArrayList<>();
		
		for(int i=0; i<people; i++) {
			System.out.println("이름: " );
			names.add(sc.next());
		}
		
		List<String> actions = new ArrayList<>();
		
		for(int i=0; i<people; i++) {
			System.out.println("항목: " );
			names.add(sc.next());
		}
		
		Collections.shuffle(actions); //위치변경
		
		for(int i=0; i<people; i++) {
			System.out.println(names.get(i) );
		}
		
	}
}
