package loop;

public class Test06 {

	public static void main(String[] args) {
		
		for(int i = 1; i <100; i++) {
			if(i % 7 == 0) {
		System.out.println("7의 배수는 = " + i);}
			
		}
		
//		for(int i =1; i <100; i++ ) {
//			if( i % 5 == 0 && i % 2 == 1 )
//			System.out.println("5가 들어간 숫자는 = " +i);	
//		} //이건 일의자리가 5만 나옴 헉!
		
//		if(i/10 == 5 || i % 10 == 5) {
//			System.out.println("5가 들어간 숫자는 = " +i);
//			boolean ten = i/10 ==5;
//			boolean one = i % 10 ==5;
//		}	
//		
//	}
		
		for(int i=1; i <= 99; i++) {
			if( i%10 ==5 || i/10 == 5) {
				System.out.println("5가 들어간 숫자는 = " +i);
			}
		}
		
		
		
		
		
		
		
		
	}

}
