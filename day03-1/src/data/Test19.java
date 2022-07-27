package data;

public class Test19 {

	public static void main(String[] args) {
		
		int inHour = 9;
		int inMinute = 50;
		int outHour = 16;
		int outMinute = 22;
		
		int inTime = inHour * 60 + inMinute;
		int outTime =  outHour * 60 + outMinute;
//		System.out.println(inTime);
//		System.out.println(outTime);
		
		int Time = outTime - inTime;
		System.out.println(Time);
		
		
		int Price = 1000;
		int Hour = 5;
		
		int Hours = Hour * 60;
		System.out.println(Hours);
		
		int TotalHours = Time - Hours;
		System.out.println(TotalHours);
		
		String a = "최초 입장 후 5시간이 지나면 10분당 1000원의 추가요금을 부과합니다.";
		System.out.println(a);
		
		boolean addCharge = Time > Hours;
		System.out.println(addCharge);
		
		int TotalPrice = TotalHours / 10 * 1000;
		System.out.println(TotalPrice);
		
	
		System.out.println("//////////");
		
		
		// 풀이 ~~~~~
		
		// 준비 
		int InHour = 9 , InMinute = 50;
		int OutHour = 16, OutMinute = 22;
		
		//계산
		int InTime = InHour * 60 + InMinute;
		int OutTime = OutHour *60 + OutMinute;
		
		int Time1 = OutTime - InTime;
		System.out.println("Time1 =" + Time1);
		
		//추가요금 
		int overPrice = (Time1 - 300) / 10 * 1000;
		System.out.println(overPrice);
		
		
		//출력
		//boolean over = 이용시간이 5시간 이상:
		//boolean over = 이용시간이 300분 이상;
		boolean over = Time1 >= 300;
		System.out.println("over = " + over);
		System.out.println("overPrice = " + overPrice);
		
		
		
		
		
		

	}

}
