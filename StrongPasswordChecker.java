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

		System.out.println("Your password is " + s + " with length " + s.length());
		
		
		if (s.length() > 20 || s.length() < 6) {
			System.out.println(s + " does not meet length criteria");
			counter++; 
		}		
		
		if (s.length() <= 20 && s.length() >= 6) {
			System.out.println(s + " meets length criteria");
			length = true;
		}
			
		if (s.matches(".*\\d.*")) {
			hasDigit = true;
			System.out.println(s + " has a digit");
		} else {
			System.out.println(s + " does not have a digit");
			counter++;
		}
		if (s.matches(".*[A-Z].*")) {
			System.out.println(s + " has an uppercase letter");
			hasUppercase = true;
		} else {
			System.out.println(s + " does not have an uppercase letter");
			counter++;
		}
		if (s.matches(".*[a-z].*")) {
			System.out.println(s + " has a lowercase letter");
			hasLowercase = true;
		} else {
			System.out.println(s + " does not have a lowercase letter");
			counter++;
		}
		if (s.matches(".*[[$&+,:;=?@#|'<>.^*()%!-]].*")) {
			System.out.println(s + " has a special character");
			hasSpecial = true;
		} else {
			System.out.println(s + " does not have a special character");
			counter++;
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
			System.out.println(s + " has letters repeating thrice");
			counter++;
		}
		
		if (hasLowercase && hasUppercase && hasDigit && hasSpecial && length && !flag) {
			System.out.println("Your password is secure");
		}
		
		
		if (counter != 0) {
			System.out.println(s + " has " + counter + " requirements not met");
		}	
				
		System.out.println("");
		
		return counter;
	    }
}
