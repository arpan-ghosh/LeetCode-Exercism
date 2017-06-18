/*
 * Validate if a given string is numeric.

	Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
	Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class ValidNumber {
	
	public boolean isNumber(String s) {
		
		if (s.isEmpty()) {
			return false;
		}
		
		if (s.charAt(0) == '.') {
			for (int j = 1; j < s.length(); j++) {
				if (Character.isDigit(s.charAt(j))) {
					j++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		
		if (Character.isDigit(s.charAt(0))) {
			for (int i = 0; i < s.length(); i++) {
				if (Character.isDigit(s.charAt(i))) {
					i++;
				}
				else {
					if ((s.charAt(i) == 'e') || (s.charAt(i) == 'E')) {
						if (Character.isDigit(s.charAt(i-1)) && Character.isDigit(s.charAt(i+1))) {
							return true;
						}
						return false;
					}
					else {
						return false;
					}
				}
			}
		}
		else {
			return false;
		}
		return true;
	}

}
