package condition;

public class Test005 {

	public static void main(String[] args) {

	
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
		
		//할인이 되는 경우와 안되는 경우는 가격만 달라지고 나머지는 똑같은데 가격 계산만 따로 할 수는 없을까?
		// total = 원래 금액 or 할인된 금액;
		
		if(totalCount >=3 ) {
			 total = ( jjajangTotal + champongTotal)* (100-discount);
		}else {
			 total = jjajangTotal + champongTotal;
		}
		System.out.println("결제금액:"+ total +"");
		
		
	
		
		//출력
		if(totalCount >= 3) { System.out.println("할인 적용!");
		int discountPrice = total * (100-discount)/100;
		System.out.println("결제금액:" +discountPrice+ "원");

			
		}else { System.out.println("할인 미적용!");
		System.out.println("결제금액:" +total +"원");
			
		}
		
	}
	}