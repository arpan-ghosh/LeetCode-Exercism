/*
 * A password is considered strong if below conditions are all met:

	It has at least 6 characters and at most 20 characters.
	It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
	It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
	Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
	
	Password*
	
	Insertion, deletion or replace of any one character are all considered as one change.
 */
public class StrongPasswordChecker {
	
	int counter = 0;
	boolean excellent = false;
	
	public int strongPasswordChecker(String s) {
		
		int candidate = s.length();
		
		if (candidate > 20 || candidate < 6) {
			counter++; 
		}
		
		if (candidate >= 6 && candidate <= 20) {
			
			if (s.matches(".*\\d+.*")) {
				excellent = true;
			} else {
				excellent = false;
				counter++;
			}
			if (s.matches(".*[A-Z].*")) {
				excellent = true;
			} else {
				excellent = false;
				counter++;
			}
			if (s.matches(".*[a-z].*")) {
				excellent = true;
			} else {
				excellent = false;
				counter++;
			}
			if (s.matches(".*[~!].*")) {
				excellent = true;
			} else {
				excellent = false;
				counter++;
			}
			if (excellent) {
				if ((s.charAt(candidate-1) == s.charAt(candidate-2)) && (s.charAt(candidate-1) == (s.charAt(candidate-3)))) {
					counter++;
				} else {
					for (int i = 0; i < s.length() - 4; i++) {
						if (s.charAt(i) == s.charAt(i+1) && s.charAt(i) == s.charAt(i+2)) {
							counter++;
						}
					}
				}
			}
		}
		return counter;
	    }
}