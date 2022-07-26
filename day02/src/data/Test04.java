package data;

public class Test04 {

	public static void main(String[] args) {
		int adult = 12000;
		int youth = 7500;
		
		int adultCount = 2;
		int youthCount = 3;
		
		int adultTotal = adult * adultCount; 
		int youthTotal = youth * youthCount; 
		
		int Total = adultTotal + youthTotal; 
		
		System.out.println("성인 요금은 다음과 같습니다.");
		System.out.println(adultTotal);
		System.out.println("청소년 요금은 다음과 같습니다.");
		System.out.println(youthTotal);
		
		System.out.println("총 결제 금액은 다음과 같습니다.");
		System.out.println(Total);
		
		
		// = 는 같다가 아니라 우측의 값을 좌측에 집어넣는 '대입' 연산 기호 


	}

}
