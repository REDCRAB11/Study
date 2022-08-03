package array2d;

public class Test05 {

	public static void main(String[] args) {
//		Test03번과 동일하게 줄과 칸 수를 입력받아 2차원 배열을 생성하고 초기화는 대각선 방향으로 하세요
//
//		```
//		줄 수 : 3
//		칸 수 : 4
//		1		3		6		9
//		2		5		8		11
//		4		7		10		12
	
		
		
		int[][] a =new int [3][4];
		int count =0;
		for(int i=0; i<2; i++) {
			for(int k=0; k<4; k++) {
				a[0][0] = 1;
				a[i][k] = count;
				count+=3;
				}
			}
		
		int count2 =2;
		for(int i=1; i<3; i++) {
			for(int k=0; k<4; k++) {
				a[i][k] = count2;
				count2 += 3;
				}
			}
		
		int count3 =4;
		for(int i=2; i<3; i++) {
			for(int k=0; k<4; k++) {
				a[i][k] = count3;
				a[2][3] = 12;
				count3 += 3;
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
