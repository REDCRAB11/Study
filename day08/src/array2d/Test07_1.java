package array2d;

import java.util.Random;

public class Test07_1 {

	public static void main(String[] args) {
		//지뢰찾기(기본문제)
		int row = 9;
		int col = 9;
		int[][] map = new int[row][col];
		
		//계산
		//1. 지뢰 무작위로 20개 배치
		Random r = new Random();
		int bomb = 20;
		for(int i=0; i < bomb; i++) {
			int x = r.nextInt(row);
			int y = r.nextInt(col);
			if(map[x][y] == 0) {//배치된 적 없는 칸이면
				map[x][y] = 9;//폭탄 배치
			}
			else {//배치된 적 있는 칸이면
				i--;//현재턴 무효화
			}
		}
		
		//출력 (폭탄을 ㉬으로 치환해서 출력)
		for(int i=0; i < row; i++) {
			for(int k=0; k < col; k++) {
				if(map[i][k] == 9) {
					System.out.print("㉬");
				}
				else {
					System.out.print(map[i][k]);
				}
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
	}
}