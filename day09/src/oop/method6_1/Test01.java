package oop.method6_1;

public class Test01 {

	public static void main(String[] args) {
		Infor a = new Infor();
		Infor b = new Infor();
		Infor c = new Infor();
		Infor d = new Infor();
		
		
		a.set("참이슬 후레쉬", "주류", 1200, true, true);
		b.set("클라우드 맥주", "주류", 3000, false, true);
		c.set("바나나킥", "과자", 1500, false, true);
		d.set("허니버터칩", "과자", 2000, true, false);
				
		a.vet();
		b.vet();
		c.vet();
		d.vet();
		
	}

}
