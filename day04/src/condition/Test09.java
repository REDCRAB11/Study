package condition;

public class Test09 {

	public static void main(String[] args) {
		
	
	int year = 2016; 
	int now = 2022;
	int age = now - year + 1; 
	System.out.println(age);
	
	
	if(age <= 7 || age >= 65) {
		System.out.println("무료 입니다.");
	 }
	else if(age >= 8 && age <= 13) {
		System.out.println("450원 입니다.");
	 }
	else if(age >= 14 && age <= 19) {
		System.out.println("720원 입니다.");
	 }
	else if(age >= 20 && age <= 64) {
		System.out.println("1250원 입니다.");
	}
		
	
	
	
	
	System.out.println("//////////");
	
	
	
	//풀이 ~~ 
	
	int birth = 20000101;
	int years = birth/10000;
	int nows = 2022; 
	int ages = nows - years +1; 
	System.out.println("ages =" + ages);
	
	//if(ages < 8 || ages >= 65)
	if(20 <= ages && ages < 65) {
		System.out.println("요금: 1250");
	//if(ages >= 20)
	}else if(14 <= ages && ages < 20) {
		System.out.println("요금: 720");
	//if(ages >= 14)
	}else if(8 <= ages && ages < 14) {
		System.out.println("요금: 450원");
	
	}else{ 
		System.out.println("요금: 0");
	}
	
	
	//풀이2 
	//int price;
	//if(ages < 8 || ages >= 65){price= 0;}
	//else if(ages >= 20){price=1250;}
	//else if(ages >= 14){price = 720;}
	//else if(ages >= 8){price = 450;}
	//System.out.println("요금:" + price + "원.");
	
	
	
	}
		

}
