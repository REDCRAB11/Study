package array;

public class Test11 {

	public static void main(String[] args) {
//		배열 뒤집기
//
//		30, 10, 20, 50, 40을 배열에 저장합니다
//		배열의 데이터를 순차적으로 출력합니다
//		배열의 모든 데이터의 위치를 반대로 변경합니다(result : 40, 50, 20, 10, 30)
//		변경된 데이터를 순차적으로 출력합니다
		
		int[] num = new int[] {30, 10, 20, 50, 40};
		
		System.out.println("배열 크기: " + num.length);
		System.out.println("반복 횟수: " + num.length/2);
		
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
		for(int i=0; i<num.length/2; i++) {
			int other = num.length - 1 - i;
			int backup = num[i];
			num[i] = num[other];
			num[other] = backup;
			
		}
		
		System.out.println("------------");
		
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
		
	}

}
