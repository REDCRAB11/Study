package regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("닉네임을 입력해주세요.(한글 또는 숫자 2-10글자 이내로)");
		String nick = sc.next();
		sc.close();
		
		String regex = "^[가-힣0-9]{210}$";
		boolean test = Pattern.matches(regex, nick);
		
		if(test) {
			System.out.println("사용가능한 닉네임 입니다.");
		}else {
			System.out.println("다시 입력해주세요.");
		}
	}

}
