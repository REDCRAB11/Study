package api.lang.String;

import java.util.Scanner;

public class Test06_4 {
	public static void main(String[] args) {
		//준비
		String [] filter = new String[] {
				"신발", "개나리", "수박", "십장생", "시베리아", "주옥", "조카", "시방", "된장", "십자수"
		};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		String text = sc.nextLine();
		sc.close();
		
		String star = "*";
		
		for(int i=0; i< filter.length; i++) {
			text = text.replace(filter[i], star.repeat(filter[i].length()));
		}
		System.out.println(text);

	}
}
