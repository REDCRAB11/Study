package data;
import java.text.DecimalFormat;
public class Test14 {

	public static void main(String[] args) {
		// BMI계산기 ,, BMI는 체질량지수를 말한다. 구하는 공식은 BMI = kg/m2
		//키 180 체중 80 bmi지수는? 
		
		int cm = 180;
		int kg = 80;
		
		double A = cm * 0.01 ;
		double A2 = A * A;
		double B = kg / A2 ;
		
		double BMI = B;
		
		System.out.println(BMI);
	
		System.out.println("///////////");
		
		
		
		//풀이 ~~~ 
	
		// 준비 - 신장(cm) 체중(kg)
		
		double height = 180;
		double weight = 80;
		
		//계산 - BMI(체중/키(m)^2)
//		double bmi = weiht / 키(m^2);
//		double bmi = weiht / (키*키);
		// 둘중하나 쓰셔 
		
		double heightMeter = height/100;
		double bmi = weight/(heightMeter*heightMeter);
		
		//출력
		System.out.println("BMI지수는 다음과 같습니다.");
		System.out.println(bmi);
		
		System.out.println("//////////");
		
		
		//추가: 소수점을 2자리까지만 표시 
		// 1. 직접구현
		double bmi2 = (int)(bmi*100)/100.0;
		System.out.println(bmi2);
		
		//2. 라이브러리 사용 
		DecimalFormat fm = new DecimalFormat("0.00");
		System.out.println(fm.format(bmi));
		
		
		

	}

}
