package oop.keyword7;

public class Leap {
	
	String name; 
	double rate;
	double extendrate; 
	int money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public  double getRate() {
		return rate;
	}
	public  void setRate(double rate) {
		if(this.rate < 0) {
			return;
		}
		this.rate = rate;
	}
	public double getExtendrate() {
		return extendrate;
	}
	public void setExtendrate(double extendrate) {
		if(this.extendrate < 0) {
			return;
		}
		this.extendrate = extendrate;
	}
	public int getMoney() {
		return money;	
	}
	public void setMoney(int money) {
		if(this.money < 0) {
			return;
		}
		this.money = money;
	}
	
	
	public double getTotla1() {
		return this.rate * this.money;
	}
	
	public double getTotal2() {
		return this.extendrate * this.money;
	}
	
	
	public Leap(String name, double extendrate, int money) {
		this.name = name;
		this.rate = 1.2;
		this.extendrate = extendrate;
		this.money = money;
	}
	
	public void vet() {
		System.out.println("<내집마련 장기적금>");
		System.out.println("이름: " + this.name);
		System.out.println("잔액: " + this.money);
		System.out.println("기본 이율: " + this.rate + ", 이율 적용 후 금액은 " + this.getTotla1());
		System.out.println("우대 이율: " + this.extendrate + ", 우대 이율 적용 후 금액은 " + this.getTotal2());
		System.out.println();
	}

}
