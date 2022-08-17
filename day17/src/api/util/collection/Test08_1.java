package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08_1 {
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("파이리");
		names.add("피카츄");
		names.add("꼬부기");
		
		List<String> actions = new ArrayList<>();
		actions.add("밥사기");
		actions.add("술사기");
		actions.add("얻어먹기");
		
		Collections.shuffle(actions); //위치변경
		
		
	}
}
