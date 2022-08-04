package array2d;

public class Test08_1 {

	public static void main(String[] args) {
		//준비
		int[][] data = new int[][] {
			{100, 90, 80, 0, 0, 0},
			{95, 92, 93, 0, 0, 0},
			{70, 95, 95, 0, 0, 0}
		};
		
		//계산
		//[1] 총점
		for(int i=0; i < data.length; i++) {
			int total = 0;
			for(int k=0; k < 3; k++) {
				total += data[i][k];
			}
			data[i][3] = total;
		}
		
		//[2] 평균
		for(int i=0; i < data.length; i++) {
			int average = data[i][3] / data[i].length;
			data[i][4] = average;
		}
		
		//[3] 순위
		for(int i=0; i < data.length; i++) {
			int rank = 1;
			int score = data[i][3];
			for(int k=0; k < data.length; k++) {
				if(score > data[k][3]) {
					rank++;
				}
			}
			data[i][5] = rank;
		}
		
		//출력
		System.out.println("국어\t영어\t수학\t총점\t평균\t순위");
		for(int i=0; i < data.length; i++) {
			for(int k=0; k < data[i].length; k++) {
				System.out.print(data[i][k]);
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
	}
}
