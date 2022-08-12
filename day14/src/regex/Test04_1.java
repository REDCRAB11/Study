package regex;

import java.util.regex.Pattern;

public class Test04_1 {

	public static void main(String[] args) {

		String date="2020-02-29";
		
		String year = date.substring(0,4);
		int yearValue = Integer.parseInt(year);
		
		boolean leapYear = yearValue % 4  == 0 && yearValue % 100 !=0 || yearValue % 400 == 0; 
			
//		String regex ="^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
		
		String regex;
		if(leapYear) {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-9])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
		}
		else {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(02-(0[1-9]|1[0-9]|2[0-8])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$";
		}
		
		boolean test = Pattern.matches(regex, date);
		 
		System.out.println(test);
	}

}
