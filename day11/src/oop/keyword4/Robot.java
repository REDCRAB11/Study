package oop.keyword4;

public class Robot { // 밑에가 풀이 ~ 위에가 내 풀이 ~ 
	
	public static int getNum(int a) {
		return a * a; 
	}
	
	public static double getBmi(double b, double c) {//static은 내 안에서만 쓰는것 ! 밖에 요소는 쓰지 않음 
		return c /((b/100) * (b/100));
	}
	
//	public static double getBvi(double b, double c ) {
//		double m = b/100;
//		return c / (m*m);
//	}
	
	public static int getPrice(int d) {
		int now = 2022;
		int age = now - d +1;
		
		int price;
		if(age < 8 || age >= 65) {
			price = 0;
		}
		else if(age >= 20) {
			price = 1250;
		}
		else if(age >= 14) {
			price = 720;
		}
		else {
			price = 450;
		}
		d = price;
		return d; 
		
	}
	
//	public static int getPrice(int d) {
//		int age = 2022 - d + 1;
//		
//		if(age < 8 || age >= 65) {
//			return 0;
//		}
//		else if(age >= 20) {
//			return  1250;
//		}
//		else if(age >= 14) {
//			return 720;
//		}
//		else {
//			return 450;
//		}
//		
//	}

	public static double getTri(double e, double f) {
		return e * f / 2;
	}
	
	// e, f를 int로하고 
	// 2.0으로 곱한다 ~ 
	
	public static double getSco(double g) {
		return g * g * Math.PI; // 변하지 않는 값으로 그냥 쓴다 3.14를 쓰든 ..
	}
	// 이건 내 풀이 ~ 
//	public static double getSco(double g, double h) {
//		return g * g * h; 
//	}
	
}
