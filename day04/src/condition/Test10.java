package condition;

public class Test10 {

	public static void main(String[] args) {
		
		
		
		int s = 20;
		
		if(s <= 10) {
			System.out.println("방금전 작성된 게시글 입니다.");
		}
		else if(s < 60) { 
			System.out.println(s +"초 전 작성된 게시글 입니다.");
		}
		else if(s < 3600 ) {
			System.out.println(s/60 + "분 전 작성된 게시글 입니다.");
		}
		
		else if(s < 86400) { 
			System.out.println(s/3600 + "시간전에 작성된 게시글 입니다. ");
		}
		else { 
			System.out.println(s/86400 + "일전 작성된 게시글 입니다. ");
		}
		
		
		
		System.out.println("/////////");
		
		
		//풀이 ~~
		
		
		int second = 2000; 
		
//		String message = "방금 전" or "초 전"or "분 전"or "시간 전"or "일 전";
		String message;
		if(second <= 10) {
			message= "방금 전";
		}
		else if(second < 1 * 60) {
			message = second + "초 전";
		}
		else if(second < 1 * 60 * 60) {
			 int minute = second/60;
			 message = minute + "분 전";
		}
		else if(second < 1 * 24 * 60 * 60) {
			int hour = second/60/60;
			message = hour + "시간 전";
		}
		else {
			int day = second/24/60/60;
			message = day + "일 전";
		}
		
		
		
		System.out.println(message);
		
		if(second <= 10) {
			System.out.println("방금 전");
		}
		else if(second < 60){
			System.out.println(second + "초 전");
		}
		else if(second < 1*60*60){
			int minute = second / 60;
			System.out.println(second/minute + "분 전");
		}
		else if(second < 1*24*60*60) {
			int hour = second/60/60;
			System.out.println(second/hour + "시간 전");
		}
		else {
			int day = second/60/60/24;
			System.out.println(second/day + "일 전");
		}
		
		
		
		
		

}
}

// if(s >= 86400) 
