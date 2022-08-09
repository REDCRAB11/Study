package oop.inherit6_1;

public class Test01 {
	public static void main(String[] args) {
		Galaxy22s a = new Galaxy22s("010-1231-1231", "블랙");
		a.call();
		a.sms();
		a.samsungPay();
		a.bicby();
		
		GalaxyFold3 b = new GalaxyFold3("010-1121-1111", "실버");
		b.call();
		b.sms();
		b.samsungPay();
		b.iris();
		
		IPhone12 c = new IPhone12("010-4884-7777", "화이트");
		c.call();
		c.sms();
		c.siri();
		c.itunes();
		
		IPhone13 d = new IPhone13("010-4222-1711", "그린");
		d.call();
		d.sms();
		d.siri();
		d.faceTime();
				
	}
}
