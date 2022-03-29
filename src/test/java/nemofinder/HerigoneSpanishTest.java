package nemofinder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nemofinder.HerigoneSpanish;

public class HerigoneSpanishTest {

	private HerigoneSpanish sut= new HerigoneSpanish();

	@Test
	public void testCleanVocals(){
		assertEquals("",sut.cleanVocals(""));
		assertEquals("",sut.cleanVocals("a"));
		assertEquals("",sut.cleanVocals("ae"));
		
		assertEquals("bc",sut.cleanVocals("abece"));
	}
	
	@Test
	public void replaceAcents(){
		assertEquals("ae",sut.replaceAcents("aé"));
	}
	
	@Test
	public void replaceSCs(){
		assertEquals("zecazico",sut.replacePhonetics("cecacico"));
	}
	
	@Test
	public void translatePhonetics(){
		assertEquals("zczc",sut.translateToPhonetics("cecacico"));
	}

}

