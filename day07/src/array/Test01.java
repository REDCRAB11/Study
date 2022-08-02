package array;

public class Test01 {

	public static void main(String[] args) {

		//배열(array)의 필요성 
		
		// ex, 5개의 정수에 대한 처리 
		
		int score = 50;
		int score2 = 75;
		int score3 = 80;
		int score4 = 65;
		int score5 = 99;
		
		// 출력 
		
		System.out.println("점수 = " + score);
		System.out.println("점수 = " + score2);
		System.out.println("점수 = " + score3);
		System.out.println("점수 = " + score4);
		System.out.println("점수 = " + score5);
		
		// 총점, 평균
		
		int total = score + score2 + score3 + score4 + score5;
		double arrange = (double)total / 5; 
		System.out.println("총점 = " + total);
		System.out.println("평균 = " + arrange);
		
		
	}

}
