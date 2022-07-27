package condition;

public class Test06 {

	public static void main(String[] args) {
		
		//준비 
		int speed = 80; 
		int limit = 50; 
		
		
		
		//계산 
		boolean over = speed > limit;
		
		int fine;
		//if(over == true) {}  밑에거랑 같은 .. 
		if(over) {
			//int fine = 벌금 계산 결과; 
			fine = 30000 +( speed - limit )/ 10 * 10000; 
			if(fine >= 70000) { fine = 70000; 
			
			}else {
				//할거 없음 없더도 되지만..
			}
		}
		else {
		     fine = 0;
			
		}
		
		
		
		
		//출력
		
		System.out.println("예상 벌금:" + fine + "원");

	}

}
