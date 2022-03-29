package nemofinder;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import nemofinder.NemoFinder;

public class NemoFinderTest {

	private NemoFinder sut = NemoFinder.NemoSpanishHeritage();

	@Test
	public void testSearch() {
		System.out.println("finding nemofinder");
		List<String> memos = sut.findNemos("801");

		printAll(memos);
	}

	public void printAll(List<String> words) {
		for (String word : words) {
			System.out.println(word);
		}
	}
	

	@Test
	public void matchesDifferentLettersInSame() {
		assertTrue(sut.matches("td", "11"));
	}

	@Test
	public void testSearchCaca() {
		List<String> found = sut.findNemos("44");
		assertTrue(found.contains("caca"));

	}
}
