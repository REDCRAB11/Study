package api.lang.String;

public class Test04 {
	public static void main(String[] args) {
		//기타 문자열 명령                     
		String a = "안녕하세요";
		
		//1.한 글자씩 추출 명령
		System.out.println(a.charAt(0));// a의 0번쨰 인덱스 글자 반환 
		
		// 반복문으로 한글자씩 출력
		for(int i=0; i<a.length(); i++) {
			char ch = a.charAt(i);
			System.out.println(ch);
		}
		
		//2. 글자 자르기 
		System.out.println(a.substring(2));
		System.out.println(a.substring(2,4));
		
		
		//3. 반복 
		String b = "똥";
		System.out.println(b.repeat(2));
		
		
		//4. 치환
		String c = "나는 피자가 좋아";
		System.out.println(c);
		System.out.println(c.replace("피자", "자바"));
		System.out.println(c.replace("피자", "**"));
		
		
	}
}
