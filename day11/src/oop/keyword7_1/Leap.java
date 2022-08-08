package oop.keyword7_1;

public class Leap {
	
	//필드 
	private	String name; // 예금주 
	private static double rate;//방법2 .. =1.2; // 기본이율
	private double extendrate;  // 우대이율
	private long money; // 잔액(억단위로 나오게 하려면 long)
	
	//static 전용 초기화 구문
	static {
		rate = 1.2; // 방법2와 뭔 차이?? 이 안에서는 식을 구현할 수 있따. 
	}
	
	
	//getter setter 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public  double getRate() {
//		return rate;
//	}
//	public  void setRate(double rate) {
//		if(rate <0) {
//			return;
//		}
//		this.rate = rate;
//	}
	public double getExtendrate() {
		return extendrate;
	}
	public void setExtendrate(double extendrate) {
		if(extendrate < 0) {
			return;
		}
		this.extendrate = extendrate;
	}
	
	public long getMoney() {
		return money;	
	}
	public void setMoney(long money) {
		if(money < 0) {
			return;
		}
		this.money = money;
	}
	
	public static void setRate(double rate) {
		Leap.rate = rate;
	}
	public static double getRate() {
		return rate;
	}
	
	
	
	public double getTotla1() {
		return this.rate * this.money;
	}
	
	public double getTotal2() {
		return this.extendrate * this.money;
	}
	
	
	//생성자에서는 static을 초기화할 필요가 없다. (한번만 초기화하도록 따로 설정)
	public Leap(String name, double extendrate, int money) {
//		Leap.rate = 1.2;  이렇게 굳이 넣을 필요가 .. ! 
		this.name = name;
		this.extendrate = extendrate;
		this.money = money;
	}
	
	public void vet() {
		System.out.println("<내집마련 장기적금>");
		System.out.println("이름: " + this.name);
		System.out.println("잔액: " + this.money);
		System.out.println("기본 이율: " + this.rate + "% 이율 적용 후 금액은 " + this.getTotla1());
		System.out.println("우대 이율: " + this.extendrate + "% 우대 이율 적용 후 금액은 " + this.getTotal2());
		System.out.println();
	}

}
