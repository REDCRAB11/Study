package oop.poly1;

public class Test01 {
	public static void main(String[] args) {
		
		//정적 객체 생성
		GalaxyFold3 a = new GalaxyFold3();
//		a.samsungPay();
		a.call();
		
		//동적 객체 생성
		Phone b = new GalaxyFold3();
//		b.samsungPay();   폰은 ---> 폰만 봐서 삼성페이는 안됨. 
		b.call();
		
		Phone c = new IPhone13();
		c.call();
	}

}
