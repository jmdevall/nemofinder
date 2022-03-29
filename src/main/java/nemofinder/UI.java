package nemofinder;

import java.util.ArrayList;
import java.util.List;

public class UI {

	public void searchAlternatives(String str,int minletters){
		Splitter s=new Splitter();
		
		List<Alternative> alternatives = s.split(str);
		List<Alternative> solutions=filter(alternatives,minletters);

		NemoFinder nemofinder = NemoFinder.NemoSpanishHeritage();
		System.out.println(String.format("Nemo Finder. Found %d alternative split solutions for number [%s]",solutions.size(),str));
		int numAlternative=1;
		for(Alternative a:solutions){
			System.out.println(String.format("\n\n===============",numAlternative,a.toString()));
			System.out.println(String.format("alternative %d %s",numAlternative,a.toString()));
			System.out.println(String.format("===============",numAlternative,a.toString()));
			
			for(String sw:a.getSubwords()){
				System.out.println("\n"+sw +" is...");
				List<String> equivalences = nemofinder.findNemos(sw);
				if(equivalences.size()==0){
					System.out.println("sorry, no words found");
				}
				printEquivalences(equivalences);
				
			}
			numAlternative++;
		}
		System.out.println("\n");
	}

	public void printEquivalences(List<String> equivalences) {
		StringBuffer sb=new StringBuffer();
		boolean first=true;
		for(String e:equivalences){
			if(first){
				first=false;
			}else{
				sb.append(", ");
			}
			sb.append(e);
		}
		System.out.println(sb.toString());
	}

	private List<Alternative> filter(List<Alternative> alternatives,int minletters) {
		List<Alternative> ret=new ArrayList<Alternative>();
		
		for(Alternative a:alternatives){
			if(a.isValid(minletters)){
				ret.add(a);
			}
		}
		return ret;
	}


	public static void main(String args[]){
		if(args.length<1){
			System.out.println("Nemo finder. print alternatives for mnemnic heritage. Usage: %command% <number> <optional_min_letters (default=1)> ");
			return;
		}
		int minletters=args.length>1?Integer.parseInt(args[1]):1;

		UI ui=new UI();
		ui.searchAlternatives(args[0],minletters);
	}
	
}
