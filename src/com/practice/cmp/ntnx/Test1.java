package com.practice.cmp.ntnx;

public class Test1 {
	static void print_nth_string(String start, int nth) {
		// scan string sstart from a positin 0 and thne scan upto n repeated
		// substring
		// and then scan how many occurences of that char appears in that
		// subsstring
		// maintain an stringbuffer that saves the substirng and then the
		// occurances.

		if (start != null && !start.isEmpty()) {
			if (nth == 0) {
				System.out.println();
				return;
			}
			if (nth == 1) {
				System.out.println(start);
				return;
			}
			int k = 2;
			while (k <= nth) {
				int size = start.length();
				char[] arr = start.toCharArray();
				StringBuilder buff = new StringBuilder();
				int counter = 1;
				char temp = arr[0]; // 510352

				if (size == 1) {
					buff = buff.append(temp).append(counter);
				} else {
					for (int i = 1; i <= size - 1; i++) {
						if (temp == arr[i]) {
							counter++;
							if (i == size - 1) {
								buff = buff.append(temp).append(counter);
							}
						} else {
							buff = buff.append(temp).append(counter);
							temp = arr[i];
							counter = 1;
							if (i == size - 1) {
								buff = buff.append(temp).append(counter);
							}
						}

					}
				}
				System.out.println(buff);
				start = buff.toString();
				k++;
				if (k > nth) {
					System.out.println(buff);
				}

			}

		}
	}

	public static void main(String[] args) {
		print_nth_string("5", 6);
	}

}
