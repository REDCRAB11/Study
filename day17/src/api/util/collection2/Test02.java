package api.util.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02 {
	public static void main(String[] args) {
		//로또 번호 추첨
		
		Set<Integer> lotto = new TreeSet<>();
		Random r = new Random();
		
		while(lotto.size() <6) {
			int number = r.nextInt(45) + 1;
			lotto.add(number);
		}
		System.out.println(lotto);
	}
}
