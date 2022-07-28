package condition;
import java.lang.*;
public class Test07 {

	public static void main(String[] args) {
		
		int p = 3;
		int per = 4;
		int month = 7;
		int dis = 25;
		
		int pri = 100000;
		
		int lent = p * per * pri; 
		System.out.println(lent);
		
		
		
		
		int lentDiscount;
		
		if(6 == month || 7 == month || 8 == month){ 
			
			lentDiscount = lent * (100-dis) / 100;
			
			System.out.println("6~8월에 이용하시는 고객님의 비용은:" + lentDiscount + "입니다.");
		
		
		
		} else{
			lentDiscount = lent;
			System.out.println("고객님의 비용은:" + lentDiscount + "입니다.");
		}
		
		
		
		
		
		System.out.println("//////////");
		
		
		
		// 풀이 ~~~~~
		
		
		//준비: 인원, 기간, 월 
		int people = 1; 
		int day = 1; 
		int months = 6;
		
		
		
		//계산
		int price = people * day * 100000; 
		int result; 
		if(6 == month || 7 == month || 8 == month) {
			result = price * 75/100;
		} else {
			result = price; 
		}
		
		//출력
		// months >= 6 && months <= 8
		// months > 5 && months <9
		//months / 3 ==2  3으로 나눠서 나머지가 2인 것들만 적용됨 
//		if(6<= months && months >= 8) {
			System.out.println("<KH여행사 영수증>");
			System.out.println("인원수:" + people + "명");
			System.out.println("여행기간:" + day +"일");
			System.out.println("1인 1박에 100000원");
			System.out.println("할인전 : " + price + "원 ");
			System.out.println("할인후:" + result + "원");
//			System.out.println("여름 특가 적용!");
//		System.out.println("요금:"  + price * 75/100 + "원");
//		} else {
//			System.out.println("<KH여행사 영수증>");
//			System.out.println("인원수:" + people + "명");
//			System.out.println("여행기간:" + day +"일");
//			System.out.println("1인 1박에 100000원");
//			System.out.println("요금:"  + price * 75/100 + "원");
//		}
		
		
	
	}

}

