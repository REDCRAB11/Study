package data;

public class Test13 {

	public static void main(String[] args) {
		
		double A = 1920; 
		double B = 50000; 
		
		double C = B / A;
		System.out.println(C);
		
     	double liter = C;
		
		System.out.println(liter);
		
		System.out.println("//////////////");
		
		//정답 ~ 
		
		int money = 50000;
		int pricePerLiter = 1920;
		
//		int Liter = money / pricePerLiter;
//		float Liter = (float)money / pricePerLiter;
		double Liter = (double)money / pricePerLiter;
		
		//위에 두개나 or 아래 더블 하나쓰면 된다. 
		
		
		System.out.println("주유 가능한 용");
		System.out.println(Liter);
	}

}
