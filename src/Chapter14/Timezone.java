package Chapter14;

import java.util.Calendar;
import java.util.TimeZone;

public class Timezone {

	public static void main(String[] args) {
		String[] st = TimeZone.getAvailableIDs();

		TimeZone seoul = TimeZone.getTimeZone("Asia/Seoul");
		TimeZone tokyo = TimeZone.getTimeZone("GMT");
		TimeZone kwangju = TimeZone.getDefault();
		System.out.println(seoul);
		System.out.println(Calendar.getInstance(tokyo).getTime());
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		System.out.println(month);
		System.out.println(kwangju);

		for(String i :st)
			System.out.println(i);
	}
}
