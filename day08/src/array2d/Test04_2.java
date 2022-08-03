package array2d;

import java.util.Scanner;

public class Test04_2 {

	public static void main(String[] args) {
	
		// 준비 
		int row=3;
		int col =4;
		int[][] arr = new int [row][col];
		
		//계산 
		// - 값 기준 
		// 1 -> 2 -> 3 -> .. -> 12(row*col)
		int x = 0;
		int y = 0;
		for(int i=1; i<=row*col; i++) {
//			System.out.println(i + "-> (" + x +" ," + y +")");
			arr[x][y] = i;
			if(x<row-1) {// 마지막 줄이 아니라면 
				x++;// 다음줄 
			}else {// 마지막 줄이라면 
				//다음 칸 첫번쨰 줄로 이동 
				y++; // 다음칸 
				x=0;
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
