package array2d;

import java.util.Random;

public class Test07 {

	public static void main(String[] args) {
//		다음 규칙에 따라 지뢰찾기를 만드세요
//
//		- 9x9 크기의 정수 배열을 준비합니다
//		- 지뢰는 9로 표시하며, 배열 내에 무작위로 20개가 배치됩니다
//		- 배치된 이후 전체 지도를 출력하세요
//
//		아래의 내용은 추가 문제이며 따로 풀이하지 않습니다
//		- 지뢰를 제외한 나머지 칸은 자신을 제외한 반경 8칸의 지뢰 개수를 세어 숫자를 기록해야 합니다
//		- 가장자리에 있는 칸의 경우 배열을 벗어나는 부분을 제외하고 계산해야 합니다
//		- 반경에 지뢰가 하나도 없다면 0이 설정됩니다
		//지뢰찾기(기본문제)
		int row = 9;
		int col = 9;
		int[][] map = new int[row][col];
		
		//계산
		//1. 지뢰 무작위로 20개 배치
		Random r = new Random();
		int bomb = 20;
		for(int i=0; i < bomb; i++) {
			int x = r.nextInt(row);
			int y = r.nextInt(col);
			if(map[x][y] == 0) {//배치된 적 없는 칸이면
				map[x][y] = 9;//폭탄 배치
			}
			else {//배치된 적 있는 칸이면
				i--;//현재턴 무효화
			}
		}
		
		//출력 (폭탄을 ㉬으로 치환해서 출력)
		System.out.println("<폭탄 배치 결과>");
		for(int i=0; i < row; i++) {
			for(int k=0; k < col; k++) {
				if(map[i][k] == 9) {
					System.out.print("㉬");
				}
				else {
					System.out.print(map[i][k]);
				}
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
		
		//2. 지뢰 제외한 나머지칸의 숫자 계산
		for(int i=0; i < row; i++) {
			for(int k=0; k < col; k++) {
				if(map[i][k] != 9) {//폭탄이 아닌 칸에만 계산을 수행한다
					//System.out.println("("+i+", "+k+") 숫자 계산 시작");//확인용 출력코드
					int xmin, xmax, ymin, ymax;
					//x 최소값 처리 : 최상단 행(x == 0)인 경우는 최소값(xmin)은 현재행
					if(i == 0) 	xmin = i;
					else 			xmin = i-1;
					//x 최대값 처리 : 최하단 행(x == row-1)인 경우는 최대값(xmax)은 현재행
					if(i == row-1) 	xmax = i;
					else					xmax = i+1;
					//y 최소값 처리 : 가장 좌측 열(y == 0)인 경우 최소값(ymin)은 현재행
					if(k == 0)	ymin = k;
					else			ymin = k-1;
					//y 최대값 처리 : 가장 우측 열(y == col-1)인 경우 최대값(ymax)은 현재행
					if(k == col-1) ymax = k;
					else			ymax = k+1;
					//System.out.println("("+xmin+", "+ymin+") 부터 ("+xmax+", "+ymax+") 까지 검사");//확인용 출력코드
					
					int count = 0;//폭탄 체크용 카운트 변수
					for(int x=xmin; x <= xmax; x++) {
						for(int y=ymin; y <= ymax; y++) {
							if(x != i || y != k) {//자기자신칸 제외
								//System.out.print(" --> ("+x+", "+y+") 검사중...");//확인용 출력코드
								if(map[x][y] == 9) {
									//System.out.println("폭탄 발견");//확인용 출력코드
									count++;//폭탄개수 카운트 증가
								}
								else {
									//System.out.println("폭탄이 발견되지 않았습니다");//확인용 출력코드
								}
							}
						}
					}
					//System.out.println("범위 내 발견된 폭탄 개수 : " + count+"개");//확인용 출력코드
					map[i][k] = count;
				}
			}
		}
		
		//출력 (폭탄을 ㉬으로 치환해서 출력)
		System.out.println("<숫자 계산 결과>");
		for(int i=0; i < row; i++) {
			for(int k=0; k < col; k++) {
				if(map[i][k] == 9) {
					System.out.print("㉬");
				}
				else {
					System.out.print(map[i][k]);
				}
				System.out.print("\t");
			}
			System.out.println();
			System.out.println();
		}
	}
}
