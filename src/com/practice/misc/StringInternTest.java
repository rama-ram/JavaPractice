import java.util.Hashtable;

public class StringInternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Rama";
		String s2 = "Rama";
		System.out.println(s1.hashCode() + " : " + s2.hashCode());
		System.out.println("is equal?? " + (s1 == s2));

		String s3 = new String(s1);
		String s4 = s1.substring(0, s1.length());
		System.out.println("S4 is " + s4);
		System.out.println(System.identityHashCode(s1) + " : " + System.identityHashCode(s2) + " :"
				+ System.identityHashCode(s3) + " : " + System.identityHashCode(s4));

		System.out.println(s1.hashCode() + " : " + s2.hashCode() + " :" + s3.hashCode());

		System.out.println("is equal?? " + (s1 == s4));
		Hashtable table1 = new Hashtable();
		table1.put(1, "test");
		Hashtable table2 = new Hashtable();
		table2.put(1, "test");
		Hashtable table3 = new Hashtable();
		table3.put(1, "test");
		System.out.println(table1.hashCode() + " : " + table2.hashCode() + " :" + table3.hashCode());

	}

}
