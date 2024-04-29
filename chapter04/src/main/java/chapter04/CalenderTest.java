package prob5;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalenderTest {

	public static void main(String[] args) {
		Calendar.getInstance();
		
		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
		TimeZone tz = TimeZone.getDefault();
		System.out.println(aLocale + ":" + tz);
		
	}

}
