package regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test02 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요.(8~20글자 이내)");
		String id = sc.next();
		sc.close();
		
 		String regex = "^[a-z][a-z0-9]{7,19}$"; // 7,19인 이유는 앞에 [a-z]가 한글자로 취급되니깐... // 그리고 [a-z0-9] 사이에 z 와 0 에는 ,(컴마)를 넣을 수 없음 아스키 코드표상 번호가 서로 다르기 땜에 ㅋ ㅋ ㅋ ㅋ 
		boolean test = Pattern.matches(regex, id); // 왼쪽이 검사식, 오른쪽이 검사값
		if(test) {
			System.out.println("사용가능한 아이디입니다.");
		}else {
			System.out.println("다시 입력해주세요.");
		}
	}

	// ^.{8,20}& .을 찍으면 아무글자나 8~20 가능 

}
