/*
 * A password is considered strong if below conditions are all met:

	It has at least 6 characters and at most 20 characters.
	It must contain at least one lowercase letter, at least one uppercase letter, one special character, and at least one digit.
	It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
	Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
	
	Password*
	
	Insertion, deletion or replace of any one character are all considered as one change.
 */
public class StrongPasswordChecker {
	
	int counter = 0;
	boolean hasLowercase = false;
	boolean hasUppercase = false;
	boolean hasDigit = false;
	boolean hasSpecial = false;
	boolean noThreeRepeat = false;
	boolean length = false;
	boolean flag = false;
	boolean all = false;
	
	public int strongPasswordChecker(String s) {

		System.out.println(s + " " + s.length());
		
		
		if (s.length() > 20 || s.length() < 6) {
			System.out.println(s + " does not meet length criteria. counter = " + counter);
			counter++; 
		}		
		
		if (s.length() <= 20 && s.length() >= 6) {
			System.out.println(s + " meets length criteria. counter = " + counter);
			length = true;
		}
			
		if (s.matches(".*\\d.*")) {
			hasDigit = true;
			System.out.println(s + " has a digit! counter = " + counter);
		} else {
			System.out.println(s + " does not have a digit! counter = " + counter);
			counter++;
		}
		if (s.matches(".*[A-Z].*")) {
			System.out.println(s + " has an uppercase letter! counter = " + counter);
			hasUppercase = true;
		} else {
			System.out.println(s + " does not have an uppercase letter! counter = " + counter);
			counter++;
		}
		if (s.matches(".*[a-z].*")) {
			System.out.println(s + " has a lowercase letter. counter = " + counter);
			hasLowercase = true;
		} else {
			System.out.println(s + " does not have a lowercase letter! counter = " + counter);
			counter++;
		}
		if (s.matches(".*[[$&+,:;=?@#|'<>.^*()%!-]].*")) {
			System.out.println(s + " has a special character! counter = " + counter);
			hasSpecial = true;
		} else {
			System.out.println(s + " does not have a special character! counter = " + counter);
			counter++;
		}
		
		if (hasLowercase && hasUppercase && hasDigit && hasSpecial && noThreeRepeat) {
		}
		
		
		if (s.length() == 3) {
			if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(3)) {
				counter++;
			}
		}
			
		int i = 0;
		
		while (i < s.length() - 2) {
			if (s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)) {
				flag = true;
				break;
			} else {
				i++;
			}
		}
		
		if (flag) {
			System.out.println(s + " has letters repeating thrice (flag). counter = " + counter);
			counter++;
		}
		System.out.println(s + " counter is: " + counter);
		System.out.println("");
		return counter;
	    }
}
