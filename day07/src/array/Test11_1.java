package array;

public class Test11_1 {

	public static void main(String[] args) {
		//배열 뒤집기
		int[] data = new int[] {30, 10, 20, 50, 40};
		
		System.out.println("배열 크기 : " + data.length);
		System.out.println("반복 횟수 : " + data.length / 2);
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		
		//뒤집기 코드
		for(int i=0; i < data.length / 2; i++) {
			int other = data.length - 1 - i;
			//System.out.println("i = " + i + " , other = " + other);
			int backup = data[i];
			data[i] = data[other];
			data[other] = backup;
		}
		
		System.out.println("----------");
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
