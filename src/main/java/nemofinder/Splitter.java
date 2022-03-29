package nemofinder;

import java.util.ArrayList;
import java.util.List;

public class Splitter {

	// Break a string into all possible combinations of non-overlapping
	// substrings
	// inspired in
	// https://www.techiedelight.com/break-string-non-overlapping-substrings/

	public List<Alternative> split(String s) {
		int starting_index = 0;
		
		List<Alternative> sol = new ArrayList<Alternative>();
		split(s, starting_index, new ArrayList<String>(), sol);

		return sol;
	}

	public static void split(String s, int i, List<String> subwords, List<Alternative> sol) {
		// base case
		if (s == null || s.length() == 0) {
			return;
		}

		if (i == s.length()) {
			sol.add(new Alternative(subwords));
		}
		
		// consider each substring `S[i, j]`
		for (int j = s.length() - 1; j >= i; j--) {
			List<String> subwords2=new ArrayList<String>(subwords);
			String substr = s.substring(i, j + 1);

			// append the substring to the result and recur with an index of
			// the next character to be processed and the result string
			
			
			subwords2.add(substr);

			split(s, j + 1, subwords2, sol);
		}
	}

}
