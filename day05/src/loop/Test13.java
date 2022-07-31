package loop;

public class Test13 {

	public static void main(String[] args) {
		
		
		int total =0;
		int money =2;
		for(int day=1; day<=1; day++) {
			System.out.println(day+"일"+day+"원");
			total += day;
		}
		for(int day=2; day<=30; day++) {
			System.out.println(day+"일" + day*money +"원" );

			total += day*money;
		}
		
		System.out.println("한달 금액은: " + total + "원");

		int total2 = 0;
		for(int day=1; day<=1; day++) {
			System.out.println(day+"일"+day+"원");
			total2 += day;
		}
		for(int day=2; day<=40; day++) {
			System.out.println(day+"일" + day*money +"원");
			total2 += day*money;
		}
		
		System.out.println("40일 동안 모은 금액은" + total2 +"원");
		
	}

}
