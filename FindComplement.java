/*Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation. */
	
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
