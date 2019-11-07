package Chapter11;

public class ReflectionTest {
	public static void main(String[] args) {
		A a = new A();
		String s1 = a.getClass().getName();
		System.out.println("Class = " + s1);
		Class[] c2 = a.getClass().getClasses();
		for (int i = 0; i < c2.length; i++) {
			String s2 = c2[i].getName();
			System.out.println("I have " + s2);
		}
	}
}

class A implements java.lang.Comparable {
	public java.util.Random r;

	public int compareTo(Object o) { return 1;}
	public class InnerA {}
	public class InnerB {}
	public class InnerC {}
}
