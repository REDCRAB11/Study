package oop.method6;

public class Test01 {

	public static void main(String[] args) {
		Infor a = new Infor();
		Infor b = new Infor();
		Infor c = new Infor();
		Infor d = new Infor();
		
		a.set("참이슬 후레쉬", "주류", 1200, "가능", "행사중");
		b.set("클라우드 맥주", "주류", 3000, "불가능", "행사중");
		c.set("바나나킥", "과자", 1500, "불가능", "행사중");
		d.set("허니버터칩", "과자", 2000, "가능", "해당없음");
		
		a.deliver += ", 배송비 +" + 2500;
		d.deliver += ", 배송비 +" + 2500;
		
		a.price = a.price*90/100;
		b.price = b.price*90/100;
		c.price = c.price*90/100;
		
		a.vet();
		b.vet();
		c.vet();
		d.vet();
		
	}

}
