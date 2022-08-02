package array;

public class Test03 {

	public static void main(String[] args) {
		//배열에 반복문 사용 
		
		int[] score = new int[5]; 
		
		score[0] = 55;
		score[1] = 75;
		score[2] = 80;
		score[3] = 65;
		score[4] = 99;

		
		//출력
		for(int i=0; i <=4; i++) {
			System.out.println("점수= " + score[i]);
		}
		
		
		
		//합계
		int total = 0;
		for(int i =0; i<=4; i++) {
			total += score[i];
		}
		System.out.println("합계= " +  total);
		
		//평균
		double avg = (double)total/5;
		System.out.println("평균= " + avg);
		
	}

}
