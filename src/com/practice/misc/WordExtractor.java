package com.practice.misc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordExtractor implements DocumentExtractor {
	private HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();

	public void foundWord(String word) {
		if (wordFrequency.get(word) == null) {
			wordFrequency.put(word, 1);
		} else {
			wordFrequency.put(word, wordFrequency.get(word) + 1);
		}
	}

	public void printTopWords(OutputStream output, int num) throws IOException {
		List<Map.Entry<String, Integer>> topWords = new ArrayList<Map.Entry<String, Integer>>();
		for (int i = 0; i < num; i++)
			topWords.add(null);

		Iterator<Map.Entry<String, Integer>> it = wordFrequency.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pairs = (Map.Entry<String, Integer>) it.next();
			for (int i = 0; i < topWords.size(); i++) {
				int topVal = 0;
				if (topWords.get(i) != null)
					topVal = topWords.get(i).getValue();

				if (pairs.getValue() > topVal) {
					topWords.set(i, pairs);
					break;
				}
			}
		}
		output.write(topWords.toString().getBytes());
	}

	@Override
	public synchronized DocumentExtractor extractFromDocument(Document doc) {
		String[] words = doc.body().text().split("\\s+");
		for (String word : words) {
			foundWord(word.toLowerCase());
		}
		return this;
	}
}
