package array2d;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
//		Test03번과 동일하게 줄과 칸 수를 입력받아 2차원 배열을 생성하고 초기화는 세로 방향으로 하세요
//
//		```
//		줄 수 : 3
//		칸 수 : 4
//		1		4		7		10
//		2		5		8		11
//		3		6		9		12
// 줄수>칸수 경우에는 실행이 안도니ㅏ?
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("줄 수: ");
		int row = sc.nextInt();
		System.out.print("칸 수: ");
		int col = sc.nextInt();
		sc.close();
		int[][] a = new int[row][col];
		
		
		int n=1; 
		for(int i =0; i<col; i++) {
			for(int k=0; k<row; k++) {
				a[k][i] = n;
				n++;
			}	
		}
		
		for(int i=0; i<a.length; i++) {
			for(int k=0; k<a[i].length; k++) {
				System.out.print(a[i][k]);
				System.out.print("\t");
			}
			System.out.println();	
		}	
		
		
	}
}