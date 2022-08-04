package oop.method5_1;

public class Test01 {

	public static void main(String[] args) {

		Infor a = new Infor();
		Infor b = new Infor();
		Infor c = new Infor();
		Infor d = new Infor();
		
		a.set("갤럭시22s", "SK", 1800000);
		b.set("갤럭시22s", "KT", 1750000, 24);
		c.set("아이폰13", "LG", 2000000, 30);
		d.set("아이폰13", "SK", 1990000);
		
		
		a.vet();
		b.vet();
		c.vet(); 
		d.vet();
	}

}
