package treesIP;

public class Validation {
	
	public boolean isNumber(String x) {
		
		for(int i=0; i<x.length(); i++) {
			if(x.charAt(i) < '0' || x.charAt(i) > '9')
				return false;
		}
		
		return true;
	}

}
