package array;

public class Test13_1 {

	public static void main(String[] args) {
	
		//준비
		int[] data = new int[] {50, 40, 30, 20, 10};

	
		
		//계산(정렬)
		for(int i=data.length-2; i>=0; i--) {
			for(int k=0; k<=i; k++) {
//				System.out.println(data[k] + "," +data[k+1]);
				if(data[k] > data[k+1]) {
					int backup = data[k];
					data[k] = data[k+1];
					data[k+1] = backup;
					}
				}
		}
		
//		for(int i=3; i>=0; i--) {
//			for(int k=0; k<=i; k++) {
//				System.out.println(data[k] + "," +data[k+1]);
//				if(data[k] > data[k+1]) {
//					int backup = data[k];
//					data[k] = data[k+1];
//					data[k+1] = backup;
//					}
//				}
//		}
//		
//		for(int i=0; i<=3; i++) {
//			System.out.println(data[i] + "," +data[i+1]);
//			if(data[i] > data[i+1]) {
//				int backup = data[i];
//				data[i] = data[i+1];
//				data[i+1] = backup;
//				}
//			}
		//위에 콛는 4번 반복 (3부터 0까지)
		
		
		
		//출력
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	
	}

}
