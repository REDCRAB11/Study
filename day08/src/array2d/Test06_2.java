package array2d;

import java.util.Random;

public class Test06_2 {

	public static void main(String[] args) {
		
		int size =3; 
		
		int[][] map = new int[size][size];
		//map.lenth 와 mp[?].lenth 가 모두 size와 같다 

		//계산  - 위치기준 
		Random r = new Random();
		for(int i=1; i<=size*size; i++) {
			int x = r.nextInt(size); 
			int y =r.nextInt(size);
			System.out.println("i= "+i+ " x= " + x + " y= "+ y);
			if(map[x][y]==0) { //데이터가 들어간적이 없는 칸이라면 
			map[x][y]=i;
		}else {// 다시 뽑아 
			i--; // 반복문에서만 사용 가능한 i--; for에서만
		}
		}
		
		
		//출력 
		for(int i=0; i<size; i++) {
			for(int k=0; k<size; k++) {
				System.out.print(map[i][k]);
				System.out.print("\t");
			}
			
			System.out.println();
			System.out.println();
		}

	}

}
