package data;

public class Test09 {

	public static void main(String[] args) {
		
		int H1 = 12; 
		int M1 = 40;
		int H2 = 16;
		int M2 = 10;
		
		int Time1 = H1 * 60 + M1;
		System.out.println(Time1);
		
		int Time2 = H2 * 60 + M2;
		System.out.println(Time2);
		
		int Time = Time2 - Time1;
		System.out.println(Time);
		
		int P = Time / 60 * 1200; 
		int P2 = Time % 60;
		System.out.println(P);
		System.out.println(P2);
		
		
		int Total = P + P2;
		System.out.println(Total);

		
		System.out.println("/////////////////////");
		
		
		
//풀이 ~ 
		
		
		//준비 - 시작시각, 종료시각, 시간당요금 
		int inH = 12;
		int inM = 40;
		int outH = 16;
		int outM = 10;
		
		int  priceH = 1200;
		
		
		//계산 - 이용시간, 이용요금 
		int inTime = inH * 60 + inM;
		int outTime = outH * 60 + outM;
		int Time3 = outTime - inTime;
//		System.out.println(Time3);
		
		
		int pM = priceH / 60;
//		System.out.println(pM);
		
		//int price = 이용시간(분) * 분당요금;
		int price = Time3 * pM;
//		System.out.println(price);
		
		int hour = Time3 / 60;
		int minute = Time3 % 60;
//		System.out.println(hour);
//		System.out.println(minute);
		
		int fixPrice = price/ 100*100; // 신규 변수 변경
		System.out.println(fixPrice);
		price = price / 100 * 100; // 기존 변수 변경
			
		
		//출력 
		System.out.println("이용시간은 다음과 같습니다.");
		System.out.println(hour);
		System.out.println(minute);
		System.out.println("이용요금은 다음과 같습니다.");
		System.out.println(4200);
		
		
	}

}
