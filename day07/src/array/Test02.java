package array;

public class Test02 {

	public static void main(String[] args) {
		// Test01을 배열을 이용하여 처리 
		// - 배열은 생성과정이 필요하다.
		// - new 키워드는 자료형에 맞게 초기값을 설정한다.
		
		int[] score = new int[5]; //new 주문제작 명령 오른쪽에 만들어질  
		// score --------> [?][?][?][?][?] 
//	                       +0 +1 +2 +3 +4	 몇칸이 떨어져 있는지 .. 
//		score 시작점에서 0칸 떨어진 위치 ---> score[0]
//		score 시작점에서 1칸 떨어진 위치 ---> score[1]
//		score 시작점에서 2칸 떨어진 위치 ---> score[2]
		
		System.out.println(score); // 리모컨 일렬번호 
		
		score[0] = 55;
		score[1] = 75;
		score[2] = 80;
		score[3] = 65;
		score[4] = 99;
//		score -----------> [55][75][80][65][99]
		
		//출력
		System.out.println("점수 = " + score[0]);
		System.out.println("점수 = " + score[1]);
		System.out.println("점수 = " + score[2]);
		System.out.println("점수 = " + score[3]);
		System.out.println("점수 = " + score[4]);
		
		
		//합계
		int total = score[0] + score[1] + score[2] + score[3] + score[4];
		System.out.println("합계= " +  total);
		
		//평균
		double avg = (double)total/5;
		System.out.println("평균= " + avg);
		
	}

}
