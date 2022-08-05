package oop.constructor2;

public class Test01 {

	public static void main(String[] args) {
		
		Infor a = new Infor("마리오", "전사", 50);
		Infor b = new Infor("루이지", "마법사");
		Infor c = new Infor("피오나", "마법사");
		
		a.vet();
		b.vet();
		c.vet();
		
		
	}

}
