
public class FindComplement {
	

    public static int findComplement(int num) {
    	
    	int numComplement = 0;
    	final int NEGATIVE = -1;
    	
    	String complement = Integer.toString(num,2);
    	
    	StringBuilder str = new StringBuilder(complement);

    	
    	for (int i = 0; i < str.length(); i++) {
    		if (str.charAt(i) == '0') {
    			str.setCharAt(i, '1');
    		} else {
    			str.setCharAt(i, '0');
    		}
    	}
    	
    	String comp = str.toString();
    	   
    	if (num < 0) {
    		numComplement = Integer.parseInt(comp,2) * NEGATIVE;
    	} else {
    		numComplement = Integer.parseInt(comp, 2);
    	}
    	
		return numComplement;
    	
    }
	
}
