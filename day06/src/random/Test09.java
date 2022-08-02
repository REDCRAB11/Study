package random;

import java.util.Random;

public class Test09 {

	public static void main(String[] args) {
		// 아이템 강화 시뮬레이션 
		// 성공 : 25% 확률로 아이템의 레빌이 +1이 돕니다. 
		// 실패 : 25% -1 
		// 현상유지 : 50% 아이템의 레빌이 변하지 않습니다. 
		// 0 레벨의 아에팀을 주어진 확률로 15레벌까지 만들기 위한 강화 횟수 구하여 출력 
		// 아이템 레벨은 0 보다 작거나 15보다 커지지는 않음 
		

		
		Random r = new Random();
		
		int item = r.nextInt();
		int level = 0;
		
		while(true) {
			
			if(item <= 25) {
				System.out.println("Su +1");
				level++;
				if(level ==15) {
				break;}
			}else if(item <= 25) {
				System.out.println("Fa -1");
				level--;
				if(0< level && level <15) {
					break;
			}
			}else {
				System.out.println("None");
			}
		
		}
		
	

	}
}
