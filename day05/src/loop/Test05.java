package loop;

public class Test05 {

	public static void main(String[] args) {
		
		//Q. 1부터 100까지 짝수/홀수를 출력 
		
		//홀수: 1, 3, 5, 7 ...... 99 
		for(int i=1; i <= 99; i+=2) {
			System.out.println("홀수 = " + i);
		}
		//짝수 
		for(int i=2; i <=100; i +=2) {
			System.out.println("짝수 = " + i);
		}
			
		
		
		//공부는 아래쪽을 공부하자 ! 
		
		for(int i =1; i <=100; i++) {
			if(i % 2 == 1) {
				System.out.println("홀수 = " + i);
			} else {
				System.out.println("짝수 = " + i);
			}
		}
		
		for(int i=1; i<=100; i ++) {if(i % 2 == 0) {
			System.out.println("짝수 = " +i);
		}
		}
		
	}

}
