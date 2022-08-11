package api.lang.String;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단어를 입력해주세요: ");
		
		String nowWord = "바나나";
		String lastWord = sc.next();
		
		char ch = nowWord.charAt(2);
		char sh = lastWord.charAt(0);
//		System.out.println(nowWord.charAt(2));
		System.out.println(nowWord.equals(lastWord));

		boolean number = nowWord.length() >=2 && lastWord.length() >=2;
		
		if(ch == sh) {
			
		}
	}

}
