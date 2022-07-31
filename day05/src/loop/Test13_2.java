package loop;

public class Test13_2 {

	public static void main(String[] args) {
		
		
		long money = 1l;
		long total = 0L;
		for(int day =1; day<=40; day++) {
			System.out.println(day+ "일" +money+ "원");
//			money += money;
			total += money;
			money *= 2;
		}
		
		System.out.println("누적 잔고:"+total+"원");
		
		
	}

}
