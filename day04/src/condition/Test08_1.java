package condition;
import java.lang.*;
public class Test08_1 {

	public static void main(String[] args) {
		//다중 조건 
		// - Q 월이 주어져 있을 때 계절을 구하여 출력. 
		// - 봄 : 3,4,5
		// - 여름 : 6,7,8,
		// - 가을 : 9,10,11
		// - 겨울 : 12,1,2
		
		//준비 
		int month = 9; 
		
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("봄");	
		}
		else if (month == 6 || month == 7 || month == 8) {
				System.out.println("여름");
		}
	    else if(month == 9 || month == 10 || month == 11) {
					System.out.println("가을");
		}
		else {
				System.out.println("겨울");  
		}
			}
		
	
}
