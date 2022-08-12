package regex;

import java.util.regex.Pattern;

public class Test01 {
	public static void main(String[] args) {
		//정규 표현식(Regular Expression)
		
		//Q. 올바른 휴대전화 전화번호인지 검사하시오 
		// www. regexper.com
		String phone = "010-1234-4567";
		
//		String regex = "^01[016789]-[123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]$";
//		String regex2 = "^01[016789]-[1-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$";
		String regex3 = "^01[016789]-[1-9][0-9]{3}-[0-9]{4}$";
		boolean test = Pattern.matches(regex3, phone);
		System.out.println("test = " + test);
		
	}
}
