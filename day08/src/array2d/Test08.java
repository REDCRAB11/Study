package array2d;

public class Test08 {

	public static void main(String[] args) {
		//https://sso-feeling.tistory.com/72
//		다음은 우리반 학생의 과목별 성적 정보입니다
//
//		| 이름 | 국어 | 영어 | 수학 | 총점 | 평균 | 순위 |
//		| :---: | :---: | :---: | :---: | :---: | :---: | :---: |
//		| 피카츄 | 100 | 90 | 80 | ? | ? | ? |
//		| 라이츄 | 95 | 92 | 93 | ? | ? | ? |
//		| 파이리 | 70 | 95 | 95 | ? | ? | ? |
//
//		- 이름을 제외한 나머지 정보들을 단 하나의 2차원 배열로 저장하고 싶습니다.
//		- 총점과 평균과 순위는 최초 0으로 설정한 뒤 계산을 통해서 채운 뒤 출력하려고 합니다
//		- 프로그래밍 코드를 작성하여 모든 정보를 채우고 출력하세요

		int[][] A = new int[][] {{ 100, 90, 80 }, 
			{ 95, 92, 93 },
			{ 70, 95, 95 }};
		
		
		int korT =0;
		int engT =0;
		int matT =0;
		
		int Total =0;
		double avg =0.0;
		int rank =0;
		
		System.out.println("  \t국어\t영어\t수학\t총점\t평균\t순위");
		System.out.println("-----------------------------------------------------");
		
		for(int i=0; i<A.length; i++) {
			
			int perT=0;
			double perAvg=0;
			
			korT += A[i][0];
			engT += A[i][1];
			matT += A[i][2];
			
			
			System.out.printf("%3d", (i+1));
			
			for(int h=0; h<A[i].length; h++) {
				perT =A[i][h];
				System.out.printf("\t%d", A[i][h]);
			}
			
			Total = perT;
			perAvg =(double)perT/A[i].length;
			avg += perAvg;
			System.out.printf("\t%d \t%.2f\n",perT, avg );
			
//			avg /= (double)A.length;
//			System.out.println("------------------------------");
//			System.out.printf("총점\t%d\t%d\t%d\t%d\t%.2f", korT, engT, matT, Total, avg, rank );

			
		}
		
		// 순위 구하기 ~ 
		
		
		
		
		
//		System.out.println("국어: "+ korT+ " 영어: "+ engT+ " 수학: " + matT
//				);
//		
//		System.out.println("평균: " + Total/3);
	}

}
