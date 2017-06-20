import static org.junit.Assert.*;

import org.junit.Test;

public class StrongPasswordCheckerTest extends StrongPasswordChecker {

	@Test
	public void testLength() {
		assertEquals(strongPasswordChecker("abcd"),4);
	}
	
	@Test
	public void testLength2() {
		assertEquals(strongPasswordChecker("abcdefghijlmnopqurst"), 3);
	}
	
	@Test
	public void testLength3() {
		assertEquals(strongPasswordChecker("abcdefghijklmnopqrstu"), 4);
	}
			
	@Test
	public void testLetters() {
		assertEquals(strongPasswordChecker("Password*"), 1);
	}
	
	@Test
	public void testLetters2() {
		assertEquals(strongPasswordChecker("Password"), 2);
	}
	
	@Test
	public void testLetters3() {
		assertEquals(strongPasswordChecker("Passworddd"),3);
	}
	
}
