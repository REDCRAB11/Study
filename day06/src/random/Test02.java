package random;

import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		int A = r.nextInt(6) + 1;
		System.out.println("주사위 결과: " + A);
		
		int D = r.nextInt(45) + 1;
		System.out.println("로또 번호: " + D);
		
		
		for(int i=1; i <7; i++) {
		int B = r.nextInt(9)  + 0;
		System.out.println(" OTP 번호:" + B);
		}
		
		int C = r.nextInt(2) + 0;
		if(C == 0) {
		System.out.println("앞면");
		}
		else {
		System.out.println("뒷면");
		}
		
	}

}
