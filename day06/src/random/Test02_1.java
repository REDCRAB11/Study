package random;

import java.util.Random;

public class Test02_1 {

	public static void main(String[] args) {
		
		
		Random r = new Random();
		
		// 1. 주사위 결과 
		
		int dice = r.nextInt(6) + 1;
		System.out.println("주사위를 던져 " + dice + "가 나왔습니다.");
		
		// 2. 로또 번호 1개 추첨
		int lott = r.nextInt(45) + 1;
		System.out.println("로또 번호: " + lott);
		// 3. OTP 1개를 생성한 결과
		int otp = r.nextInt(900000) + 100000; // 6자리가 다 나옴 
//		int otp = r.nextInt(1000000); // +0;은 쓰나마나  5자리가 나오는 경우도 있다.앞에 0이 안나와서 
		System.out.println("otp 번호: " + otp);
		
		
		// 4. 동전을 던져 예상되는 결과 
		// - 약속: 0은 앞으로  1은 뒷면으 간주한다. 
//		int coin = r.nextInt(2) + 0; // 0부터 하는게 좋다 .. 
		int coin = r.nextInt(2);
//		System.out.println("coin: " + coin);
		if(coin == 0 ) {
			System.out.println("앞");
		}else {
			System.out.println("뒤");
		}
		
	}

}
