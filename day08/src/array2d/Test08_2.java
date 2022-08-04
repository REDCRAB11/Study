package array2d;

public class Test08_2 {

	public static void main(String[] args) {
	//Test08은 정수배열이라 평균을 제대로 보여줄 수 없는 문제가 존재
		
		//준비
		float[][] data = new float[][] {
			{100, 90, 80, 0, 0, 0},
			{95, 92, 93, 0, 0, 0},
			{70, 95, 95, 0, 0, 0}
		};
		
		//계산
		//[1] 총점
		for(int i=0; i < data.length; i++) {
			float total = 0;
			for(int k=0; k < 3; k++) {
				total += data[i][k];
			}
			data[i][3] = total;
		}
		
		//[2] 평균
		for(int i=0; i < data.length; i++) {
			float average = data[i][3] /3;
			//소수점 1자리 처리
			average = (int)(average * 10) / 10f;
			data[i][4] = average;
		}
		
		//[3] 순위
		for(int i=0; i < data.length; i++) {
			int rank = 1;
			float score = data[i][3];
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
				//평균만 float로 출력하고 나머지는 int로 변환하여 출력
				if(k==4) {
					System.out.print(data[i][k]);
				}
				else {
					System.out.print((int)data[i][k]);
				}
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
	}
}