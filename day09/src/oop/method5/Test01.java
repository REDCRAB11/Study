package oop.method5;

public class Test01 {

	public static void main(String[] args) {

		Infor a = new Infor();
		Infor b = new Infor();
		Infor c = new Infor();
		Infor d = new Infor();
		
		
		a.set("갤럭시22s", "SK", 180, "약정없음");
		b.set("갤럭시22s", "KT", 175, "24개월");
		c.set("아이폰13", "LG", 200, "30개월");
		d.set("아이폰13", "SK", 199, "약정없음");
		
		
//		b.price = b.price/24;
//		c.price = c.price/30;
		
		a.price = a.price*95/100;
		d.price = d.price*95/100;
		
		
		a.vet();
		b.vet();
		System.out.println("할부금은" + b.price/24 + "만원");
		System.out.println();
		c.vet(); 
		System.out.println("할부금은" + c.price/30 + "만원");
		System.out.println();
		d.vet();
	}

}
