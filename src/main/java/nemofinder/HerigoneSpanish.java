package nemofinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HerigoneSpanish implements Phonetics {
	
	public HerigoneSpanish(){
		init();
	}
	
	private String vocals = "[aeiou]";

	private Map<String, List<String>> herigone;

	private List<String> phoneticSet;
	private Map<String, String> invPhonetics;

	private Map<String, String> inv(Map<String, List<String>> memos) {
		Map<String, String> inv = new HashMap<String, String>();

		for (Entry<String, List<String>> memo : memos.entrySet()) {
			List<String> values = memo.getValue();
			for (String value : values) {
				inv.put(value, memo.getKey());
			}

		}
		return inv;
	}
	
	private void init() {
		herigone = new HashMap<String, List<String>>();

		herigone.put("0", Arrays.asList("r", "rr"));
		herigone.put("1", Arrays.asList("t", "d"));
		herigone.put("2", Arrays.asList("n", "ñ"));
		herigone.put("3", Arrays.asList("m"));
		herigone.put("4", Arrays.asList("c", "k", "q"));
		herigone.put("5", Arrays.asList("l", "ll"));
		herigone.put("6", Arrays.asList("s", "z")); //also "c" in ce and ci sounds differently
		herigone.put("7", Arrays.asList("f", "j"));
		herigone.put("8", Arrays.asList("g", "ch"));
		herigone.put("9", Arrays.asList("v", "b", "p"));

		this.invPhonetics = inv(herigone);
		this.phoneticSet = new ArrayList<String>(invPhonetics.keySet());
	}

	/* (non-Javadoc)
	 * @see nemofinder.Phonetics#translateToPhonetics(java.lang.String)
	 */
	@Override
	public String translateToPhonetics(String word){
		return cleanVocals(replacePhonetics(replaceAcents(word)));
	}
	
	public String replaceAcents(String word){
		return word.replaceAll("[á]", "a")
				.replaceAll("[é]", "e")
				.replaceAll("[í]", "i")
				.replaceAll("[ó]", "o")
				.replaceAll("[ú]", "u");
	}
	
	public String replacePhonetics(String word){
		return word.replaceAll("[c]e", "ze").replaceAll("[c]i", "zi");
	}
	
	public String cleanVocals(String word) {
		return word.replaceAll(vocals, "");
	}

	@Override
	public List<String> getPhoneticSet() {
		return this.phoneticSet;
	}

	@Override
	public String getPhoneticInv(String str) {
		return this.invPhonetics.get(str);
	}

}
