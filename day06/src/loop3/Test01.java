package loop3;

public class Test01 {

	public static void main(String[] args) {
		
		// while 반복문 - 특정 시점까지 반복하는 반복문
		// for 반복문 - 횟수나 범위가 주어졌을 때의반복문 
		
		
		// ex, 1부터 10까지 출력
		for(int i=1; i<= 10; i ++) {
			System.out.println(i);
		}
		
		int n=1; 
		while( n <=10) {
			System.out.println(n);
			n++;	
		}
		
//		System.out.println(n);   while은 밖에서도 사용 가능하다. 
		
	}

}
