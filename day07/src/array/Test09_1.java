package array;

import java.util.Scanner;

public class Test09_1 {

	public static void main(String[] args) {
		
		// 배열 준비 
		int[] data = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<data.length; i++) {
			data[i]=sc.nextInt();
		}
		sc.close();
		
		for(int i=0; i<data.length; i++) {
//			System.out.println("data = " + data);
		}
		
		int total=0;
		for(int i=0; i<data.length; i++) {
			total +=data[i];
		}
		System.out.println("total = " + total);
		
		double avg = (double)total/data.length;
		System.out.println("average = " + avg);
		
	}

}
