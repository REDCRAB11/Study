package data;

public class Test03 {

	public static void main(String[] args) {
		
	//변수를 사용해서 Test02 개선 
		
		//변수 준비 
		int jjajang = 5000; //jjajang이라는 이름의 저장소에 5000저
		int champon = 6000;
		int jjajangCount = 2; //이름에 띄어쓰기하면 안된다. 같이 쓰면 뒤에 문자만 대문자로해서 구분한다. 
		int champonCount = 3;
		
//		System.out.println(jjajang * jjajangCount);
//		System.out.println(champon * champonCount);
//		
//		System.out.println(jjajang * jjajangCount + champon * champonCount);		
		
		
		int jjajangTotal = jjajang * jjajangCount; //계산 결과를 저장 
		int champonTotal = champon * champonCount;
		int total = jjajangTotal + champonTotal;
		
		//출력 단계 
		
		System.out.println(jjajangTotal);
		System.out.println(champonTotal);
		System.out.println(total);		
	

	}

}
