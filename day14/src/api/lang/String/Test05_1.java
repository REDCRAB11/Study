package api.lang.String;

public class Test05_1 {

	public static void main(String[] args) {
		String given ="바나나";
		String input ="나이스";
		
		//계산
		// - given & input이 이어집니까?
		// 1. .charAt()
//		boolean good = given.charAt(2) == input.charAt(0);   이거는 쿵쿵따일때만 가능 !
		boolean good = given.charAt(given.length()-1) == input.charAt(0);
		
		//2. substring(), equals() 사용  
//		boolean good2 = given.substring(2).equals(input.substring(0,1)); 이거사용해도 되고 밑에거 사용해도 되고 상관없더요 
		boolean good2 = given.substring(given.length()-1).equals(input.substring(0,1));
		
		
		//3. substring(), startWith() 사용 
//		boolean good3 = input.startsWith(given.substring(2));
		boolean good3 = input.startsWith(given.substring(given.length()-1));
		
		
		//4. substring(), indexOf() 사용
//		boolean good4= input.indexOf(given.substring(2)) ==0;
		boolean good4 = input.indexOf(given.charAt(given.length()-1)) ==0;
		
		
		
		//출력
		if(good) {
			System.out.println("이어져");
		}else {
			System.out.println("안이어져");
		}
	}

}
