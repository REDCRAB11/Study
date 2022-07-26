package data;

public class Test11 {

	public static void main(String[] args) {
		//성적 평균 계산 
		
		int korean = 90;
		int english = 87;
		
		//계산 
		int total = korean + english;
//		double average = total / 2.0 ;
		// double average = total / 2d;
	    double average = (double)total / 2d; //변환(cast)연산
		
		//출력
		System.out.println("시험 평균");
		System.out.println(average);
	

	}

}
