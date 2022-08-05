package array2d;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
		int row = 3; 
		int col = 4;
		
		
		int [][] a = new int [row][col];
		
		int count =1; 
		for(int i =0; i<a.length; i++) {
			for(int k=0; k<a.length; k++) {
				a[i][k] = count++;
			}
			
		}
		
		for(int i =0; i<a.length; i++) {
			for(int k=0; k<a.length; k++) {
			
				System.out.println(a[i][k]);
				System.out.println("\t");
				
			 }
			}
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		int[][] a = new int [3][4];		
//		
//		int[][] b = new int [][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		
//		int count = 0; 
//		
//			for(int i=0; i<=1; i++) {
//				for(int k=0; k<=2; k++) {
//				System.out.print(b[i][k]);
//				System.out.print("\t");
//			}
//				System.out.println();
//			}
//				
//			for(int i=0; i<b.length; i++) {
//				for(int k=1; k<b[i].length; k++ ) {
//					System.out.print(b[i][k]);
//					System.out.print("\t");
//			}
//				System.out.println();
//			}
//			
				
		}

}
