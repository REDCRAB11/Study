package array;

public class Test05_1 {

	public static void main(String[] args) {

		// 성적 데이텉 준비 
		int[] score = new int[] {75, 92, 86, 65, 79, 95, 88, 86, 72, 77};
		
		// 성적 출력 
		for(int i=0; i< score.length; i++) {
			System.out.println("점수 = " + score[i]);			
		}
		
		// 평균 출력 
		
		int total = 0;
		for(int i=0; i < score.length; i++) {
			total += score[i];
		}
		int avg = total/score.length;
		System.out.println("평균 = " + avg);
		
		
		// 90점 이상 출력 
		int count =0;
		for(int i=0; i<score.length; i++) {
			if(score[i] >= 90) {
//			System.out.println("점수 = " + score[i]); 헷갈리면 이거 써서 봐도 뭐..
				count++;
			}
		}
		
		System.out.println("성적 우수자는 = " + count + "명");
		
		
		// 85점 몇등?
		// 85점 보다 높은 점수의 개수 + 1
		
		int rank = 1; 
//		int student = 85;  해서 85에 넣어서 스캐너 만들어서 하면 직접 값을 이용한 등수를 알 수 있다. 
		for(int i=0; i< score.length; i++) {
			if(score[i] > 85) {
				rank++;
			}
		}
		System.out.println("예상 등수 = " +rank + "등");
		
	}

}
