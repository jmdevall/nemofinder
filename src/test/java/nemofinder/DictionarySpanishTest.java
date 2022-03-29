package nemofinder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import nemofinder.Dictionary;
import nemofinder.DictionarySpanish;

public class DictionarySpanishTest {

	@Test
	public void canSupplyWords() {
		Dictionary sut=new DictionarySpanish();
		List<String> words = sut.getWords();

		assertNotNull(words);

		assertFalse(words.isEmpty());
		assertTrue(words.size() > 20);
	}
}
