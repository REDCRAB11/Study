package api.util.date;

import java.util.Date;

public class Test01 {

	public static void main(String[] args) {
		//시간 다루기
		Date a = new Date(); // 한국식으로 형식 재정의(format) 한다. 
		Date b = new Date(2022,8,16); // 안씀  
		Date c = new Date(22,8,16); // 안씀 
		
		System.out.println("a= " + a);
		System.out.println("b= " + b);
		System.out.println("c= " + c);

		
		
		
	}

}
