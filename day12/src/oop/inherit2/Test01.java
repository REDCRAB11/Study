package oop.inherit2;

public class Test01 {

	public static void main(String[] args) {
		// 상속이 잘 되었는지 확인하기 위한 코드 
		Galaxy22s a = new Galaxy22s();
		Iphone13 b = new Iphone13();
		
		
		a.call();
		a.camera();
		a.samsungPay();
		
		b.call();
		b.camera();
		b.itunes();
		
	}
}
