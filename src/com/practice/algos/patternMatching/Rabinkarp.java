package com.practice.algos.patternMatching;

public class Rabinkarp {
	// 3. rabin Karp -- generate hash for the text to search, then make
	// substrings from the original text of size of substirng and then generate
	// hash n see if hash matches, if so, then match charc, if matches, then say
	// there is a match , else, recalculate the hash.
	// Time Comple O (m*n)
	public static final int prime = 256;

	public static void main(String[] args) {
		Rabinkarp rks = new Rabinkarp();
		System.out.println(patternParser("TusharRoy", "sharRoy"));
		System.out.println(patternParser("TusharRoy", "Roy"));
		System.out.println(patternParser("TusharRoy", "shas"));
		System.out.println(patternParser("TusharRoy", "usha"));
		System.out.println(patternParser("TusharRoy", "Tus"));
	}

	static int patternParser(String text, String patt) {

		char[] txt = text.toCharArray();
		char[] pat = patt.toCharArray();

		int txtSize = txt.length;
		int patSize = pat.length;

		long patHash = createHash(pat, patSize - 1);
		long txtHash = createHash(txt, patSize - 1);

		for (int i = 1; i <= txtSize - patSize + 1; i++) {
			if (patHash == txtHash && checkEqual(txt, i - 1, i + patSize - 2, pat, 0, patSize - 1)) {
				return i - 1;
			}
			if (i < txtSize - patSize + 1) { // 10-7+1
				txtHash = recalculateHash(txt, i - 1, i + patSize - 1, txtHash, patSize);
			}
		}

		return -1;
	}

	private static boolean checkEqual(char str1[], int start1, int end1, char str2[], int start2, int end2) {
		if (end1 - start1 != end2 - start2) {
			return false;
		}
		while (start1 <= end1 && start2 <= end2) {
			if (str1[start1] != str2[start2]) {
				return false;
			}
			start1++;
			start2++;
		}
		return true;
	}

	private static long createHash(char[] str, int end) {
		long hash = 0;
		for (int i = 0; i <= end; i++) {
			hash += str[i] * Math.pow(prime, i);
		}
		return hash;
	}

	private static long recalculateHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLen) {
		long newHash = oldHash - str[oldIndex];
		newHash = newHash / prime;
		newHash += str[newIndex] * Math.pow(prime, patternLen - 1);
		return newHash;
	}
}