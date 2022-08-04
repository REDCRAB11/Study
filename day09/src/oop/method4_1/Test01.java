package oop.method4_1;

public class Test01 {

	public static void main(String[] args) {
		
		Infor a = new Infor();
		Infor b = new Infor();
		Infor c = new Infor();
		Infor d = new Infor();
		
		a.set("아메리카노", "음료", 2500, true);
		b.set("모카라떼", "음료", 3500);
		c.set("치즈케이크", "디저트", 5000,true);
		d.set("마카롱", "디저트", 3000); 
		
		a.vet();
		b.vet();
		c.vet();
		d.vet();
		
		
	}

}
