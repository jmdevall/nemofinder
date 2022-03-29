package nemofinder;

import java.util.List;

import org.junit.Test;

import nemofinder.Alternative;
import nemofinder.Splitter;

public class SplitterTest {
	
	@Test
	public void splites() {
		Splitter sut=new Splitter();
		
		// input string
		String s = "ABCD";

		List<Alternative> sol =sut.split(s);

		System.out.println(sol.get(0));
		
	}


}
