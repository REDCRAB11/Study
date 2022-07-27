package condition;

public class Test01 {

	public static void main(String[] args) {
		
		//조건부 코드
		// - 특정 상황에서만 실행되는 코드 
		
		
		//준비 
		int number = 7;
		
		//계산
		int mod = number % 2; 
		
//		boolean odd = 나머지가 1이면 홀수;
//		boolean even = 나머지가 0이면 짝수;
		
		boolean odd = mod == 1;
		boolean even = mod == 0;
		System.out.println(odd);
		System.out.println(even);
		
		//출력
		if(odd==true){//이 영역은 odd라는 변수가 true일 때 실행되어야 한다.
			System.out.println(number + "는 홀수입니다.");
		}
		if(even==true){//이 영역은 even이라는 변수가 true일 때 실행되어야 한다. 
			System.out.println(number + "는 짝수입니다.");
		}
		

	}

}
