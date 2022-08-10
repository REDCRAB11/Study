package oop.poly2_2;

public class Test01 {

	public static void main(String[] args) {

		int type = 1; 
		int action =3; 
		
		//type을 이용해서 전화기(Phone)를 하나 생성(업캐스팅: 하위요소를 상위형태로 보관)
		Phone phone; 
		if(type ==1) {
			phone = new Galaxy22s();
		}else if(type ==2) {
			phone = new GalaxyFold3();
		}else if(type ==3) {
			phone = new IPhone12();
		}else {
			phone = new IPhone13();
		}
		
		if(action == 1) {
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
