package data;

public class Test16 {

	public static void main(String[] args) {
		//문자열(String)
		// - 쌍따음표를 이용해서 글자를 저장
		// - 크키는 만들어봐야 알 수 있다.(주문제작 형태)
		// - 참조형 데이터(reference type) 면접에 많이 나옴!
		// - 부가적인 명령들을 사용할 수 있다. 
		
		
		String a = "Hello";
		System.out.println(a);
		System.out.println(a.length());
		System.out.println(a.toUpperCase());

		// - 문자열은 덧셈은 가능하다. 
		System.out.println("Hello" + "Java");
		
		int money = 500;
		System.out.println("소지금은"+money+"원 입니다.");
		
		// - 출력이 되지 않는 특이한 형태의 글자들이 있다. 
		// - \t : tab(띄어쓰기)
		// - \n: new line(줄바뀜)
		
//		String b = "가	나	다라마";
		String b = "가\n나\t다\t라\t";
		System.out.println(b);
		
		//문자열 변수를 만들어 다음 글자를 저장 후 출력
		// - 나는 지금 "피자"가 먹고 싶어요. 
		
		String c = "나는 지금 \"피자\"가 먹고 싶어요.";
		System.out.println(c);
		
		String d = "D:\\study";
		System.out.println(d);
		
	}

}
