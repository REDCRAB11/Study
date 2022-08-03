package array2d;

public class Test03_3 {

	public static void main(String[] args) {

		// 준비 
		int row = 3;
		int col = 4;
		
		int[][] arr = new int [row][col];
		// arr.length는 row와 같다. 
		// arr[?].length는 col과 같다. 
		
		//계산 
		// - 기준을 (줄, 칸)이 아니라 숫자로 보면?
		// - 1부터 row*col까지 반복하도록 반복문을 구성 
		
		int x=0, y=0;
		for(int i=1; i<= row*col; i++) {
//			System.out.println(i+"를 (" +x+ "," +y+ ")에 대입합니다.");
			arr[x][y]=i;
			if(y<3) { // 3= col-1
			y++; //다음칸
			}else {
				x++; // 다음줄
				y=0; // 첫칸
			}
		}
		

		
		
		
		
		
		
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
