package api.util.calendar;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Test03 {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		int year=2022, mon=7, day=115;
		
		c.set(year, mon, day);
		
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(f.format(d));

	}

}
