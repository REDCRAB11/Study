package api.lang.String;

public class Test06_1 {
	public static void main(String[] args) {
		//준비
		String [] filter = new String[] {
				"신발", "개나리", "수박", "십장생", "시베리아", "주옥", "조카", "시방", "된장", "십자수"
		};
		
		System.out.print("입력: ");
		String text = " 이런 신발끈 개나리같은 수박씨를 보았다";
		
//		System.out.println(text);
//		System.out.println(text.replace(filter[0], "***"));
//		System.out.println(text.replace(filter[1], "***"));
		
		for(int i=0; i<=1; i++) {
			text = text.replace(filter[i], "***");
			
		}
//		text = text.replace(filter[1], "***");
		System.out.println(text);

	}
}
