package array;

public class Test12_2 {

	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//1턴: 전체 배열에서 가장 작은 숫자의 위치를 찾아 맨 앞에 데이터와 교체 
		
		//최소값 찾기 
		int min =1; 
		for(int i=2; i<=4; i++) {
			if(data[min]>data[i]) { // 더 작은 값을 발견하면 ~
				min = i;
			}
		}
		
		System.out.println("min: " + min);
	
		//교체
		int backup = data[1];
		data[1]=data[min];
		data[min]=backup;
		
		
		//출력 
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	
		
	}

}