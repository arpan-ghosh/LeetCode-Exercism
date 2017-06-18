import static org.junit.Assert.*;

import org.junit.Test;

public class isNumberTest extends ValidNumber {

	@Test
	public void testAllNumbers() {
		assertTrue(isNumber("1234"));
		assertTrue(isNumber("100.4"));
		assertTrue(isNumber("4.3"));
		assertTrue(isNumber(".4"));
		assertTrue(isNumber("1E3"));
		assertTrue(isNumber("1e44"));
	}
	
	@Test
	public void testLetters() {
		assertFalse(isNumber("HELLO"));
		assertFalse(isNumber(".43ZD"));
		assertFalse(isNumber("432.d"));
	}

}
