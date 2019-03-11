
public class FizzBuzz {

	public static void main(String[] args) {
		numberPrinter(15);
	}

	private static void numberPrinter(int i) {
		int counter = 1;
		while (counter <= i) {
			System.out.println(counter % 3 == 0 ? (counter % 5 == 0 ? "FIZZBUZZ" : "FIZZ")
					: (counter % 5 == 0 ? "BUZZ" : counter));
			counter++;
		}
	}

}
