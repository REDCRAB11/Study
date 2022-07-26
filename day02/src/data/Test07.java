package data;

public class Test07 {

	public static void main(String[] args) {
		
		//Q. 1시간 40분 + 2시간 30분 = ? 
		
		//준비 
		
		int H1 = 1;
		int M1 = 40;
		int H2 = 2;
		int M2 = 30; 
		
		//계산
		
		int time1 = 60 * H1 + M1; 
//		System.out.println(time1);
		
		int time2 = 60 * H2 + M2; 
//		System.out.println(time2);
		
		int time = time1 + time2;
		int H = time / 60;
		int M = time % 60;
		
		//출력 
		System.out.println(H);
		System.out.println(M);
		System.out.println(time);
		
	}

}
