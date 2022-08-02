package array;

public class Test05 {

	public static void main(String[] args) {
		
		// 우리반 학생들의 시험 성적 = 75, 92, 86, 65, 79, 95, 88, 86, 72, 77 
		
		int score[] = new int[] {75, 92, 86, 65, 79, 95, 88, 86, 72, 77 };
		
		
		for(int i =0; i < score.length; i++) {
			System.out.println("점수: " + score[i]);
		}
		
		int total = 0;
		for(int i =0; i<score.length; i++) {
			total += score[i];
		}
		
		int avg = total/score.length;
		System.out.println("평균: " + avg);
		
		int count=0;
		for(int i=0; i<score.length; i++) {
		if(score[i] >=90) {
			count++;	
		}
		}
		System.out.println("90점 이상: " + count + "명");
		
		int count2=0;
		for(int i=0; i<score.length; i++) {
			if(score[i] >=85) {
				count2++;
		}
		}
		
		System.out.println(count2 + 1 + "등 입니다.");
		
	}

}
