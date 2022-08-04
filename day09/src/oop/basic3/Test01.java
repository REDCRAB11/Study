package oop.basic3;

public class Test01 {

	public static void main(String[] args) {
		
		System.out.println("통신사 요금제 정보");
		System.out.println();
		
		Information a = new Information();
		
		a.telephon = "Sk";
		a.name = "5G언택트 52";
		a.cost = 52000;
		a.data = 200; 
		a.minute = 1000;
		a.message = 2000;
		
		System.out.println(a.telephon);
		System.out.println("상품명: " + a.name);
		System.out.println("월 정액: " + a.cost + "원");
		System.out.println("데이터: " + a.data + "GB");
		System.out.println("통화: " + a.minute + "분");
		System.out.println("문자: " + a.message + "건");
		
		System.out.println("-------------");
		
	Information b = new Information();
		
		b.telephon = "KT";
		b.name = "5G세이브";
		b.cost = 45000;
		b.data = 100; 
		b.minute = 900;
		b.message = 1500;
		
		System.out.println(b.telephon);
		System.out.println("상품명: " + b.name);
		System.out.println("월 정액: " + b.cost + "원");
		System.out.println("데이터: " + b.data + "GB");
		System.out.println("통화: " + b.minute + "분");
		System.out.println("문자: " + b.message + "건");
		
		System.out.println("-------------");
		
	Information c = new Information();
		
		c.telephon = "LG";
		c.name = "5G시그니처";
		c.cost = 130000;
		c.data = 500; 
		c.minute = 2000;
		c.message = 2500;
		
		System.out.println(c.telephon);
		System.out.println("상품명: " + c.name);
		System.out.println("월 정액: " + c.cost + "원");
		System.out.println("데이터: " + c.data + "GB");
		System.out.println("통화: " + c.minute + "분");
		System.out.println("문자: " + c.message + "건");
	}

}
