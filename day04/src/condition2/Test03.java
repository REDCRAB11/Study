package condition2;

public class Test03 {

	public static void main(String[] args) {
		
		int month = 10;
		switch(month) {
		case 1: 
			System.out.println("31일");
			break;
		case 2: 
			System.out.println("28일");
			break;
		case 3: 
			System.out.println("31일");
			break;
		case 4: 
			System.out.println("30일");
			break;
		case 5: 
			System.out.println("31일");
			break;
		case 6: 
			System.out.println("30일");
			break;
		case 7: 
			System.out.println("31일");
			break;
		case 8: 
			System.out.println("31일");
			break;
		case 9: 
			System.out.println("30일");
			break;
		case 10: 
			System.out.println("31일");
			break;
		case 11: 
			System.out.println("30일");
			break;
		case 12: 
			System.out.println("31일");
			break;
		
		}
		
		
		
		System.out.println("//////////");
		
		
		
		// 풀이 ~~~ 
		
		//준비 
		int mon = 5;
		
		//출력 
		switch(month) {
		case 2: 
			System.out.println("28일");
			break;
		case 4: 
		case 6: 
		case 9:  
		case 11: 
			System.out.println("30일");
			break;
		case 1:
		case 3: 
		case 5: 
		case 7: 
		case 8: 
		case 10:
		case 12: 
			System.out.println("31일");
			break;

		}
		
		
		// 풀이 2 
		
		switch(mon) {
		case 2: 
			System.out.println("28일");
		break;
		case 4: 
		case 6: 
		case 9: 
		case 10: 
		case 11: 
			System.out.println("30일");
			break;
			default:
				System.out.println("31일");
				break;
		
		}
		
		//풀이3 
		
		int max;
		switch(mon) {
		case 2:
		max = 28;
		break;
		case 4: case 6: case 9: case 11:
			max =30;
		break;
		default:
			max=31;
		break;
		}
		System.out.println(max+"일");
		
		
		
		
		
		
		
	}

}
