package nemofinder;

import java.util.ArrayList;
import java.util.List;

public class NemoFinder {
	
	private Dictionary dictionary;
	private Phonetics phonetics;

	public NemoFinder(Dictionary dictionary,Phonetics phonetics) {
		this.dictionary=dictionary;
		this.phonetics=phonetics;
	}
	
	public static NemoFinder NemoSpanishHeritage(){
		return new NemoFinder(new DictionarySpanish(),new HerigoneSpanish());
	}

	public List<String> findNemos(String desired) {

		List<String> found = new ArrayList<String>();
		for (String word : dictionary.getWords()) {
			String phoneticWord = phonetics.translateToPhonetics(word);
			
			if (matches(phoneticWord, desired)) {
				found.add(word);
			}

		}
		return found;
	}


	public boolean matches(String phoneticword, String desired) {
		String equivalence=getPhoneticEquivalence(phoneticword);
		return equivalence!=null && equivalence.equals(desired);
	}
	
	private String getPhoneticEquivalence(String phoneticword){
		int offset = 0;
		String equivalence = "";

		while (offset < phoneticword.length()) {
			boolean found = false;
			for (String test : this.phonetics.getPhoneticSet()) {
				if (phoneticword.startsWith(test, offset)) {
					offset += test.length();
					equivalence = equivalence + this.phonetics.getPhoneticInv(test);
					found = true;
				}
			}
			if (!found) {
				return null;
			}
		}
		return equivalence;
	}



}
