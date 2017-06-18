import static org.junit.Assert.*;

import org.junit.Test;

public class LongestValidParenthesesTest extends LongestValidParentheses{

	@Test
	public void testOnePair() {
		assertEquals(longestValidParentheses("()"), 2);
	}
	
	@Test
	public void testTwoPair() {
		assertEquals(longestValidParentheses("()())"), 2);
	}
	
	@Test
	public void testWrong() {
		assertEquals(longestValidParentheses("3jr"), 0);
	}
	
	@Test
	public void testAllFail() {
		assertEquals(longestValidParentheses("((()(()"), 2);
	}

}
