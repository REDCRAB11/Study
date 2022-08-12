package api.lang.String;

public class Test06_5 {
	public static void main(String[] args) {
		String [] filter = new String[] {
				"신발", "개나리", "수박", "십장생", "시베리아", "주옥", "조카", "시방", "된장", "십자수"
		};
		
		System.out.print("입력: ");
		String text = " 이런 신발끈 개나리같은 수박씨를 보았다";
		String star = "*";
		
		for(int i=0; i<filter.length; i++) {
			text = text.replace(filter[i], star.repeat(filter[i].length()));
		}
		System.out.println(text);
		
	}
}
