import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListPickNumbersFirst {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.add("test0");
		ll.add(5);
		ll.add("test1");
		ll.add(3);

		for (Object o : ll)
			System.out.println(o.toString());
		System.out.println("after re-arranging");
		LinkedList ll2 = LinkedListPickNumbersFirst.pickNumbersFirst(ll);
		for (Object o : ll2)
			System.out.println(o.toString());

	}

	private static LinkedList pickNumbersFirst(LinkedList ll) {
		ArrayList arr1 = new ArrayList();
		ArrayList arr2 = new ArrayList();

		for (Object o : ll) {
			if (o instanceof Integer)
				arr1.add(o);
			else
				arr2.add(o);
		}
		LinkedList ll2 = new LinkedList();
		for (Object o : arr1)
			ll2.add(o);
		for (Object o : arr2)
			ll2.add(o);
		return ll2;
	}

}
