package data;

public class Test08 {

	public static void main(String[] args) {
		
		int H = 3;
		int M = 30; 
		
		int time =  60 * 3 + 30;
		
		System.out.println(time);
		
		System.out.println("0 ~ 9분 무료");
		int P1 = 0;
		System.out.println("10 ~ 19분 무료");
		int P2 =1000;
		System.out.println("이후 10분당 1000원씩 추가");
		int P3 =1000;
		
		int A = 0;
		int B = 9;
		int C = 201;
		
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		
		int P = A*0 + B*1000 + C*1000;
		
		
		System.out.println(P);
		
		System.out.println("////////////////");
		
		
//정답 ~ 들어온 시간(시/분) 나간 시간(시/분)
		
		int inH1 = 12;
		int inM1 = 40;
		int outH2 = 16;
		int outM2 = 10;
		
		//계산 - 가장 작은 단위로 변경해서 계산 후 원래 형태로 복원 
		
		
		//시간
		int inTime = inH1 * 60 + inM1;
		System.out.println(inTime);
		
		int outTime = outH2 * 60 + outM2;
		System.out.println(outTime);
		
		int Time = outTime - inTime;
		System.out.println(Time);
		
//		 int hour = time / 60;
//		 int minute = time % 60;
//		System.out.println(hour);
//		System.out.println(minute);
		
		//요금
		int Price = Time / 10 *1000;
		System.out.println("주차요금은 다음과 같습니다.");
		System.out.println(Price);
		
		


	}

}
