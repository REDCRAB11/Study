package loop;

public class Test13_1 {

	public static void main(String[] args) {
		
		
		int money = 1;
		int total = 0;
		for(int day =1; day<=30; day++) {
			System.out.println(day+ "일" +money+ "원");
//			money += money;
			total += money;
			money *= 2;
		}
		
		System.out.println("누적 잔고:"+total+"원");
		
		
		
		
	}

}
