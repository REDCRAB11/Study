package condition;

public class Test06 {

	public static void main(String[] args) {
		
		int overkm = 50;
		int overPrice = 10000;
		int startPrice = 30000;
		int car = 100; 
		
		int km = car - overkm; 
		
		int Price = startPrice + km / 10 * overPrice;
		
		
		
		if(car > overkm ) { System.out.println("현재 주행 속도는:" + car + "입니다." + "제한속도를 초과하였습니다. 범칙금 "+ Price + "부과됩니다. ");
		
		if(Price > 70000) { System.out.println("범칙금 지불하세요. ");
		
		}else {System.out.println("안전운전 하세요. ");
		
		}
		
		
//		if(Price < 70000) {System.out.println("범칙금은 7만원을 초과할 수 없습니다.");}
//		if(Price > 70000) { System.out.println("범칙금 지불하세요. ");
//		
		}

	}

}

//7만원 초과할 수 없다를 어떻게 하냐고 ~ 