package array2d;

public class Test03_1 {

	public static void main(String[] args) {

		// 준비 
		int row = 3;
		int col = 4;
		
		int[][] arr = new int [row][col];
		// arr.length는 row와 같다. 
		// arr[?].length는 col과 같다. 
		
		//계산 
		arr[0][0]=1;
		arr[0][1]=1;
		arr[0][2]=1;
		arr[0][3]=1;
		
		arr[1][0]=1;
		arr[1][1]=1;
		arr[1][2]=1;
		arr[1][3]=1;
		
		//노가도 있따.
		
		
		//출력
		for(int i =0; i <arr.length; i++) {
			for(int k=0; k<arr[i].length; k++) {
				System.out.print(arr[i][k]);
				System.out.print("\t");
			}
			
			System.out.println();
		}
		
		

	}

}
