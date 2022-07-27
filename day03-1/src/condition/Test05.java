package condition;

public class Test05 {

	public static void main(String[] args) {
		
		int a = 5000;
		int b = 6000;
		int c = a *2 + b*1;
		int d = 3; 
		int e = a * d; 
		
		double f = c * 90/100;
		
	
		
		if(c >= e){ System.out.println("3그릇 이상 주문시 10%할인 결제금액은"+ f + "입니다.");
		}
		else { System.out.println("3그릇 미만 주문시 10%할인 대상 아님.");
		}
		
		
		System.out.println("//////////");
		
		
		
		// 풀이 ~~~
		
		
		//준비 : 자장 금액, 수량 ... 짬 금액, 수량...
		int jjajang  = 5000;
		int jjajangCount = 2;
		int champong = 6000;
		int champongCount = 1;
		int discount = 10; //할인율 
		
		//계산 
		int totalCount = jjajangCount + champongCount; 
		int jjajangTotal = jjajang * jjajangCount;
		int champongTotal = champong * champongCount;
		int total = jjajangTotal + champongTotal;
		
	
		
		//출력
		if(totalCount >= 3) { System.out.println("할인 적용!");
		int discountPrice = total * (100-discount)/100;
		System.out.println("결제금액:" +discountPrice+ "원");

			
		}else { System.out.println("할인 미적용!");
		System.out.println("결제금액:" +total +"원");
			
		}
		
	}
	}
