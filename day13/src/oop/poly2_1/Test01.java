package oop.poly2_1;

public class Test01 {

	public static void main(String[] args) {
		// 준비
		
		int type = 1;
		int action = 1;
		
		if(type ==1) {
			Galaxy22s phone = new Galaxy22s();
			if(action ==1) {
				phone.camera();
			}else if(action ==2) {
				phone.gallery();
			}else if(action ==3) {
				phone.call();
			}else {
				phone.sms();
			}
			
		} 
		else if(type ==2) {
			GalaxyFold3 phone = new GalaxyFold3();
			if(action ==1) {
				phone.camera();
			}else if(action ==2) {
				phone.gallery();
			}else if(action ==3) {
				phone.call();
			}else {
				phone.sms();
			}
		}
		else if(type ==3) {
			IPhone12 phone = new IPhone12();
			if(action ==1) {
				phone.camera();
			}else if(action ==2) {
				phone.gallery();
			}else if(action ==3) {
				phone.call();
			}else {
				phone.sms();
			}
			
		}
		else if(type ==4) {
			IPhone13 phone = new IPhone13();
			if(action ==1) {
				phone.camera();
			}else if(action ==2) {
				phone.gallery();
			}else if(action ==3) {
				phone.call();
			}else {
				phone.sms();
			}
		}
	}

}
