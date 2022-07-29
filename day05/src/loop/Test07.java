package loop;

public class Test07 {

	public static void main(String[] args) {
		
		for(int i=1; i <=99 ; i++) {
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9 ) {
				System.out.println("짝");
			}
			if(i / 10 ==3 || i / 10 == 6 || i / 10 == 9) {
				System.out.println("짝짝");
			}
			else {
				System.out.println(i);
			}
			
		
		}
		

	
	
	}
	

}