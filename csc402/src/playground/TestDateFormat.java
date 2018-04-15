package playground;

import java.text.*;
import java.util.*;
//import java.text.SimpleDateFormat;
//import java.time.format.*;

public class TestDateFormat {

	public static void main(String[] args) {
		//Date d = new Date(2017, 02, 06, 15, 36, 40);
		//System.out.printf("%s %tB %<td", d);
		//System.out.printf("%s", d);

		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy", Locale.US);
		//Date today = new Date();
		
		String sToday = "Mon Feb 06 15:36:40 CST 2017";
		DateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
		
		//Date today = new Date(2017,02,06);
		
		//Date today = (Date)sdf.parse(sToday);
		
		//sdf.format(new Date(2017,02,06));
		//String d = sdf.format(today);
		//String d = sdf.format(new Date(2017,02,06));
		//System.out.println(d);
		
		/*DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.FULL );
		f = f.withLocale( Locale.CANADA_FRENCH );
		
		System.out.println(f);*/
		

	}

}
