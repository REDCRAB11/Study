package array;

public class Test04 {

	public static void main(String[] args) {
		//배열에 반복문 사용 
		
		int[] score = new int[] {55, 75, 80, 65, 99}; 
		
		System.out.println(score.length);
		
		//출력
		for(int i=0; i <score.length; i++) {
			System.out.println("점수= " + score[i]);
		}
		
		//합계
		int total = 0;
		for(int i =0; i<score.length; i++) {
			total += score[i];
		}
		System.out.println("합계= " +  total);
		
		//평균
		double avg = (double)total/score.length;
		System.out.println("평균= " + avg);
		
	}

}
