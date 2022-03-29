package nemofinder;

import java.util.List;

public interface Phonetics {

	String translateToPhonetics(String word);
	List<String> getPhoneticSet();
	String getPhoneticInv(String str);
	
}