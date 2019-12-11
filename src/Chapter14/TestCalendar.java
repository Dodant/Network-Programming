package Chapter14;

import java.util.*;

public class TestCalendar {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(1969, 13, 2, 0, 0, 0);
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DATE));
	}
}
