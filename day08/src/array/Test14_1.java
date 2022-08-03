package array;

import java.util.Arrays;

public class Test14_1 {

	public static void main(String[] args) {
		// 삽입 정렬(insertion sort)
		// -  모든 자리의 값을 순차적으로 백업 후 들어갈 자리를 만들어 삽입하는 정렬 
		
		
		//준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		
		//정렬
		for(int i=0; i <data.length; i++) {
			int backup = data[i]; // 현재 위치(i)의 데이터를 백업
			int index = i;   // 현재 위치(i)를 들어갈 위치로 설정 
			
			
			for(int k=i-1; k >=0; k--) {// 앞부분을 스캔하기 위한 반복문 
//			System.out.println(index + "," + i);
				if(backup < data[k]) {
					data[k+1] = data[k];  // 한칸 우측으로 복사 
					index--; // 들어갈 위치를 한칸 왼쪽으로 조정 
				}
				else {
					break; //중지 
				}
			}
			data[index] = backup;
		}
		
//		System.out.println("index: " + index);
		
		
		//출력
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}

	}

}
