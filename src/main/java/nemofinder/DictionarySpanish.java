package nemofinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DictionarySpanish implements Dictionary{

	@Override
	public List<String> getWords() {
		return loadWords("/spanish.txt");
	}

	public List<String> loadWords(String file) {
		Reader reader = new InputStreamReader(this.getClass().getResourceAsStream(file));

		List<String> words = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException e) {
			throw new IllegalStateException("could not load words");
		}

		return words;
	}
}
