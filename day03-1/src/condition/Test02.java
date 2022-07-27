package condition;

public class Test02 {

	public static void main(String[] args) {
	
		int Test1 = 85;
		int Test2 = 52;
		
		int total = Test1 + Test2;
//		System.out.println(total);
		System.out.println("총점은" +total +"입니다." );
		
		double average = (double)total / 2; 
//		System.out.println(average);
		System.out.println("평균점수는" + average);
		
		if(average >= 60){ System.out.println(average + "통과"); }
		if(average <= 60){ System.out.println(average + "재시험");}
		
		
		System.out.println("//////////");
		
		
		//풀이 ~~
		
		//준비 
		int exam1 = 35;
		int exam2 = 52;

		//계산 
		int Total = exam1 + exam2;
		double avg = (double)Total / 2;
	
		
		//출력 
	    System.out.println("평균 점수 = " + avg +"점");
	    if(avg >= 60) {	System.out.println("통과입니다"); 
	    }
		if(avg <= 60) {System.out.println("재시험을 보셔야 합니다.");
		}
		
		
		
		
		
		
		
	}

}
