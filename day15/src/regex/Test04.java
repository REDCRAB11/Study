package regex;

import java.util.regex.Pattern;

public class Test04 {

	public static void main(String[] args) {

		String date = "2002-12-25";
		
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";
		boolean test = Pattern.matches(regex, date);
		System.out.println("test: " + test);
	}

}
