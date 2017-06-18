
/*
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

	For "(()", the longest valid parentheses substring is "()", which has length = 2.

	Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
	
	public int longestValidParentheses(String s) {
		
		int counter = 0;
		
		if (!s.contains("()")) {
			return 0;
		}
		
		
		if (s.equals("()")) {
			return 2;
		} else {
			for (int i=0; i < s.length(); i++) {
				if ((s.charAt(i) == '(') && (s.charAt(i+1) == ')')) {
					counter++;
				} 
			}
			return counter;
		}
		        
    }

}