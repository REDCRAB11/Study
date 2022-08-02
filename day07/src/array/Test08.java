package array;

public class Test08 {

	public static void main(String[] args) {
		
		//배열 데이터 교체(swap)

		int[] data = new int[] {30,20,10,50,40};
		
		//20과 40을 교체 ( 맞교환이 안됨)
//		data[1]=data[4];
//		data[4]=data[1];

		int backup = data[1]; //계산을 위해 필요한것 쓰고 버릴 수 있똬 . . 
		data[1]=data[4];
		data[4]=backup;
		
		//출력
		for(int i=0; i <data.length; i++) {
		System.out.println(data[i]);
		}
	}

}
