package array2d;

public class Test05_2 {

	public static void main(String[] args) {
		//배운내용에 가장 근접한 풀이
		
				//준비
				int row = 3;
				int col = 4;
				
				int[][] arr = new int[row][col];
				
				//계산
				//- 합계가 늘어나면서 합계를 기준으로 x 위치를 계산하고 합계 - x위치로 y위치를 계산
				int x = 0;
				int y = 0;
				for(int i=1; i <= row * col; i++) {
					//System.out.println(i + " → ("+x+", "+y+")");//확인용코드
					arr[x][y] = i;
					
					x--; y++;//우측 상단으로 이동
					if(x < 0 || y >= col) {//만약 오른쪽이든 위쪽이든 벗어났다면
						y++;//우측으로 한칸 이동하고
						while(true) {
							x++; y--;//좌측 하단으로 이동
							//System.out.println("x = " + x + ", y = " + y);//확인용코드
							//배열 좌측끝 혹은 하단 끝이면 탈출
							if(x == row-1 || y == 0) {
								break;
							}
						}
					}
				}
				
				//출력
				for(int i=0; i < arr.length; i++) {
					for(int k=0; k < arr[i].length; k++) {
						System.out.print(arr[i][k]);
						System.out.print("\t");
					}
					System.out.println();
				}
			}
		}