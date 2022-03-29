package nemofinder;

import java.util.ArrayList;
import java.util.List;

public class Alternative {
	private List<String> subwords;
	
	public Alternative(){
		this.subwords=new ArrayList<String>();
	}
	
	public Alternative(List<String> subwords){
		this.subwords=subwords;
	}
	
	public boolean isValid(int minLength) {
		for(String subword:subwords){
			if(subword.length()<=minLength){
				return false;
			}
		}
		return true;
	}
	
	public List<String> getSubwords() {
		return subwords;
	}
	
	public void addSubword(String subword){
		if(!"".equals(subword)){
			this.subwords.add(subword);	
		}
	}

	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		
		for (String aa : subwords) {
			sb.append("{");
			sb.append(aa);
			sb.append("}");
		}
		return sb.toString();
		
	}
}
