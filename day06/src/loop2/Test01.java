package loop2;

public class Test01 {

	public static void main(String[] args) {
		
		//중첩 반복문 
		//하루동안의 메세지를 출력
		
		for(int hour=0; hour<24; hour++) {
			
			for(int min=0; min<60; min++) {
			for(int sec=0; sec<60; sec++) {
				System.out.println(hour + "시" + min + "분" + sec + "초");
				
			}
		}}
		
		
//		for(int i = 0; i < 3660; i++) {
//			System.out.println(i/60 +"분 " + i%60 + "초");
//		}
//		
	}

}
