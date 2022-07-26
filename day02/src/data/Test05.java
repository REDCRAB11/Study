package data;

public class Test05 {

	public static void main(String[] args) {
		
		int americano = 1300;
		int latte = 2000;
		
		int americanoCount = 4;
		int latteCount = 3;
		
		int americanoTotal = americano * americanoCount;
		int latteTotal = latte * latteCount;
		
		int Total = americanoTotal + latteTotal;
		
		System.out.println("아메리카노 금액은 다음과 같습니다.");
		System.out.println(americanoTotal);
		System.out.println("라떼 금액은 다음과 같습니다.");
		System.out.println(latteTotal);
		
		System.out.println("총 결금액은 다음과 같습니다.");
		System.out.println(Total);
		
		
	
	}

}
