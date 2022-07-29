package loop;

public class Test07_1 {

	public static void main(String[] args) {
		
		//풀이 씹탱아.. 
		
		// 1. 1~99까지 출력 
//		for(int i = 1; i <= 99; i++) {
//			System.out.println(i);
//		}
//		
		// 2. 박수를 치는 숫자와 아닌 숫자 구분하여 출력
		
//		for(int i = 1; i <= 99; i++) {
			
//				boolean three =  i/10 == 3 || i % 10 ==3;
//				boolean six = i/10 == 6 || i%10 == 6;
//				boolean nine = i/10 == 9 || i%10== 9;
//				
//
//				
//				if(three || six|| nine) {
//				System.out.println("박수!");
//			}else {
//				System.out.println(i);
//				
//			
//		}
		
		for(int i =1; i <=99 ; i++) {
				boolean ten = i/10==3 || i/10==6 || i/10==9;
				boolean one = i%10==3 || i%10==6 || i%10==9;
			if(ten||one) {
				if(ten&&one){
					System.out.println("짝짝");
				}
				else {
					System.out.println("짝");}
	
				}
				else {
					System.out.println(i);
				}
			}
		}
	
}

				
				
				
				
	

