package io;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
		System.out.println("BMI 계산입니다.");
		Scanner sc = new Scanner(System.in);
		System.out.println("키를 입력해 주세요.");
		double cm = sc.nextDouble();
		System.out.println("몸무게를 입력해 주세요.");
		double kg = sc.nextDouble();
		sc.close();
		
		double cm2 = cm/100 * cm/100;
		double BMI = kg/cm2;

		double BMI2 = (int)(BMI*100)/100.0;
		System.out.println(BMI2);
		
		if(BMI > 24.5){System.out.println("비만");
		}
		else { System.out.println("정상");
		}
		
		
		System.out.println("//////////");
		

		// 풀이 ~~
		
		
		//준비 
		Scanner sc1 = new Scanner(System.in);
		System.out.print("신장 입력:");
		double cm1 = sc1.nextDouble(); 
		System.out.print("체중 입력:");
		double kg1 = sc1.nextDouble();
		sc1.close();
		
		//계산 
		double m = cm1/100;
		double bmi = kg1 / (m * m);
		
		//출력
		System.out.println("BMI:" + bmi);
	
		if(bmi > 24.5) {
			System.out.println("비만입니다.");
		}else {
			System.out.println("정상입니다.");
		}
		
		
		
		
	}

}
