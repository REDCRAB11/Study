package array;

public class Test13 {

	public static void main(String[] args) {
		// Test12과 같은 데이터를 버블정렬(BUBBLE SORT)을 통해 오름차순으로 정렬하고 출력해보세요
		

		int[] A = new int[] { 30, 10, 20, 50, 40 };

		int B;
		for(int i=0; i<A.length; i++) {
			for(int h=i+1; h<A.length; h++) {
				if(A[h] > A[i]) {
					B = A[h];
					A[h] = A[i];
					A[i] = B;
				}
			}
		}
	
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
	
	}

}
