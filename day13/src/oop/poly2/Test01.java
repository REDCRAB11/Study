package oop.poly2;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Phone a = new Galaxy22s();
		Phone b = new GalaxyFold3();
		Phone c = new IPhone12();
		Phone d = new IPhone13();
		
		System.out.println("휴대폰 종류를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int list = sc.nextInt();
		
		System.out.println("수행할 작업의 종류를 입력하세요");
		int use = sc.nextInt();
		
		switch(list) {
		case 1:
//			System.out.println("Galaxy22s");
			break;
		case 2:
//			System.out.println("GalaxyFold3");
			break;
		case 3:
//			System.out.println("IPhone12");
			break;
		case 4:
//			System.out.println("IPhone13");
			break;
		}
		
		
		
		switch(use) {
		case 1:
			if(list ==1 ) {
				a.camera();				
			}else if( list == 2) {
				b.camera();				
			}else if(list ==3 ) {
				c.camera();
			}else {
				d.camera();				
			}
			break;
		case 2:
			if(list == 1) {
				a.gallery();				
			}else if(list == 2) {
				b.gallery();				
			}else if(list ==3) {
				c.gallery();				
			}else {
				d.gallery();				
			}
			break;
		case 3:
			if(list == 1) {
				a.call();				
			}else if(list == 2) {
				b.call();				
			}else if(list ==3) {
				c.call();				
			}else {
				d.call();				
			}
			break;
		case 4:	
			if(list == 1) {
				a.sms();				
			}else if(list == 2) {
				b.sms();				
			}else if(list ==3) {
				c.sms();				
			}else {
				d.sms();				
			}
			break;
		}
	}
}
