package oop.inherit6;

public class Test01 {

	public static void main(String[] args) {
		Galaxy22s a = new Galaxy22s("010-1234-1234", "블랙");
		
		a.call();
		a.sms();
		a.samsungPay();
		a.bixby();
		System.out.println();
		
		GalaxyFold3 b = new GalaxyFold3("010-4567-4567", "화이트");
		
		b.call();
		b.sms();
		b.samsungPay();
		b.iris();
		System.out.println();

		
		Iphone12 c = new Iphone12("010-9876-9876", "블랙");
		
		c.call();
		c.sms();
		c.itunes();
		c.siri();
		System.out.println();

		
		Iphone13 d = new Iphone13("010-5443-5443", "로즈골드");
		
		d.call();
		d.sms();
		d.faceTime();
		d.siri();
		
		
				
	}

}
