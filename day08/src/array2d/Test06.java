package array2d;

import java.util.Random;

public class Test06 {

	public static void main(String[] args) {
//		다음 규칙에 따라 빙고판을 만드세요
//
//		- 5x5 크기의 정수 배열을 준비합니다
//		- 1부터 25까지의 숫자를 무작위 위치에 배치합니다
//		- 한 칸에는 한 번만 값을 배치할 수 있습니다
//		- 크기가 달라질 경우에도 달라진 크기에 맞게 빙고판이 만들어져야 합니다
		
		
		int size = 5; 
		int [][] map = new int[size][size];
		
		Random r = new Random();
		for(int i=0; i<size; i++) {
			for(int k=0; k<size; k++) {
				map[i][k] = r.nextInt(25)+1;
			}
		}
		
		for(int i=0; i<size; i++) {
			for(int k=0; k<size; k++) {
				System.out.println(map[i][k]);
				System.out.println("\t");
			}
			System.out.println();
			System.out.println();
		}
		
		
	}

}

//		Random r = new Random();
//	
//		int[][] A = new int[5][5];
//		int count = 1;
//		int random = r.nextInt();
//		
//		for(int i=0; i<A.length; i++) {
//			for(int k=0; k<A[i].length; k++) {
//				A[i][k] = count;
//				count++;
//			}
//		}
//
//
//		for(int i=0; i<A.length; i++) {
//			for(int k=0; k<A[i].length; k++) {
//				System.out.print(A[i][k]);
//				System.out.print("\t");
//			}
//			System.out.println();
//		}