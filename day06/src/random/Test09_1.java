package random;

import java.util.Random;

public class Test09_1 {
	public static void main(String[] args) {
		Random r = new Random();
		
		int item = 0;
		
		int count = 0;
		
		while(true) {
			
			int enchant = r.nextInt(100) + 1;
			count++;
		
			if(enchant <= 25) {//성공
				if(item < 15) {
					item++;
					System.out.println("강화 성공");
				}
				else {
					System.out.println("이미 최대 레벨입니다");
				}
			}
			else if(enchant <= 50) {//실패
				if(item > 0) {
					item--;
					System.out.println("강화 실패");
				}
				else {
					System.out.println("강화 레벨이 더 이상 내려갈 수 없습니다");
				}
			}
			else {//현상유지
				System.out.println("아무 일도 일어나지 않았습니다");
			}
			
			System.out.println("현재 강화 레벨 : " + item);
			if(item == 15) {
				break;
			}
		}
		
		System.out.println("강화 시뮬레이션 종료!");
		System.out.println("강화 시도 횟수 : " + count+"번");
		
	}
}