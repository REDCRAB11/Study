package random;

import java.util.Random;

public class Test06_1 {

	public static void main(String[] args) {

		
		
		Random r = new Random();
		int count = 0;
		
		while(true) {
		//주사위 2개를 던진 결과를 저장 
		int a = r.nextInt(6) + 1;
		int b = r.nextInt(6) + 1;
		
		System.out.println("a = " + a + " b= " + b);
		
		count++; //break 부문에 넣으면 브레이크는 포함되지 않음..
		
		//if( a==5 && b ==5 || a ==6 && b ==6)
		if(( a== 5 && b ==5) || ( a ==6 && b ==6)){
			break;
		}
		
		}
		
		System.out.println("총 " + count + "번 던졌습니다.");
		
	}

}
