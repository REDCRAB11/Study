package array;

public class Test12_4 {

	public static void main(String[] args) {
		
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		
		for(int i=0; i<data.length-1; i++) {
			//1턴: 전체 배열에서 가장 작은 숫자의 위치를 찾아 맨 앞에 데이터와 교체 
			
			//최소값 찾기 
			
			int min =i;   // int min = 0; 0 =i 
			for(int k=i+1; k<data.length; k++) {
				if(data[min]>data[k]) { // 더 작은 값을 발견하면 ~
					min = k;
				}
			}
			
			
			//교체
			int backup = data[i];
			data[i]=data[min];
			data[min]=backup;
		}
		
//		System.out.println("min: " + min);s
		
		//출력 
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	
		
	}

}