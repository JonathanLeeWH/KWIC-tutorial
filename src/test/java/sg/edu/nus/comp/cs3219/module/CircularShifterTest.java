package sg.edu.nus.comp.cs3219.module;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;
import sg.edu.nus.comp.cs3219.model.LineStorage;

public class CircularShifterTest {
	LineStorage inputLineStorage;
	LineStorage afterShiftLineStorage;
	CircularShifter shifter;

	@Before
	public void setUp() {
		inputLineStorage = new LineStorage();
		afterShiftLineStorage = new LineStorage();
		shifter = new CircularShifter(afterShiftLineStorage);
		Set<String> words = new HashSet<>();
		words.add("the");
		words.add("after");
		shifter.setIgnoreWords(words);
		inputLineStorage.addObserver(shifter);
	}

	@Test
	public void test() {
		inputLineStorage.addLine("The Day after Tomorrow");
		assertEquals(2, afterShiftLineStorage.size());

		assertEquals("Day after Tomorrow the", afterShiftLineStorage.get(0).toString());
		assertEquals("Tomorrow the Day after", afterShiftLineStorage.get(1).toString());
	}

	@Test
	public void test1() {
		// Add an additional test case where the lines input does not contain any of the ignored words.
		inputLineStorage.addLine("Hello World");
		assertEquals(2, afterShiftLineStorage.size());

		assertEquals("Hello World", afterShiftLineStorage.get(0).toString());
		assertEquals("World Hello", afterShiftLineStorage.get(1).toString());
	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void test2() {
		// Add an additional test where the lines input contain ALL the ignored words.
		inputLineStorage.addLine("the after");
		assertEquals(0, afterShiftLineStorage.size());

		// Since Junit 4 is used instead of Junit 5 assertThrows method is not available.
		exceptionRule.expect(IndexOutOfBoundsException.class);
		afterShiftLineStorage.get(0);
	}
}
