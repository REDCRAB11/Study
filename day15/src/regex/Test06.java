package regex;

import java.util.regex.Pattern;

public class Test06 {

	public static void main(String[] args) {

		String password = "Hello1234!!!";
		String regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$";
		boolean test = Pattern.matches(regex, password);
		System.out.println("결과: " + test);
		
	}

}
