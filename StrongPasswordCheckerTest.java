import static org.junit.Assert.*;

import org.junit.Test;

public class StrongPasswordCheckerTest extends StrongPasswordChecker {

	@Test
	public void testLength() {
		assertEquals(strongPasswordChecker("abcd"),4);
		assertEquals(strongPasswordChecker("abcdefghijlmnopqurst"), 3);
		assertEquals(strongPasswordChecker("abcdefghijklmnopqrstu"), 4);
	}
	
	@Test
	public void testLetters() {
		assertEquals(strongPasswordChecker("Password*"), 2);
		assertEquals(strongPasswordChecker("Password"), 4);
		assertEquals(strongPasswordChecker("Passworddd"),3);
	}

}
