package condition;

public class Test04 {

	public static void main(String[] args) {
		
		int me = 1995;
		int older = 1958, kid = 2016, now = 2022; 
		
		int age1 = now - older +1;
		int age2 = now - kid +1;
		int age3 = now - me +1;
		
		System.out.println(age1);
		System.out.println(age2);
		System.out.println(age3);
		
		boolean freeBus = age2 <= age3 && age3 >= age1;
		
		
		if(freeBus == true) {System.out.println("무임승차 대상입니다.");
				}
		if(freeBus == false) {System.out.println("무임승차 대상이 아닙니다.");
		}
		
		
		System.out.println("//////////");
		
		
		
		
		
		//풀이 ~ 
		
		
		//준비 - 출생년도 4자리 
		int year = 2000;
		int now1 = 2022; 
		
		
		//계산 - 나이 
		int age = now1 - year +1; 
		
		
		//출력
		System.out.println("당신의 나이는" + age + "입니다.");
		
		// 나이가 7살 이하 또는 65세 이상이라
		if(age <= 7 || age >= 65){System.out.println("무임승차 대상입니다.");
		} 
		//나이가 7살 초과 그리고 65세 미만이라
//		if(age > 7 && age <65){System.out.println("무임승차 대상이 아닙니다. ");
//	
//		}
		else{//if가 거짓말이면
			System.out.println("무임승차 대상이 아닙니다. ");
		}
	//else는 단독으로 쓰일 수 없다. if 다음에 else 쓰여야 한다. 	
		
	// 복습하세요 ~~~~~
	}
	

}
