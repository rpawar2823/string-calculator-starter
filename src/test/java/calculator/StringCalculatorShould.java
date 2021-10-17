package calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

	@Test
	public void sumsTwoNumbersSeperatedByComma() {
		assertThat(StringCalculator.sum("1,2"), is(3));
		assertThat(StringCalculator.sum("1,3"), is(4));
		}

	@Test
	public void sumsThreeNumbersSeperatedByComma() {
		assertThat(StringCalculator.sum("1,2,3"), is(6));
		}
	@Test
	public void sumsNumbersDelimitedByNewline() {
		assertThat(StringCalculator.sum("1\n2"), is(3));
		}

	@Test
	public void sumsNumbersDelimitedByCommaOrNewline() {
		assertThat(StringCalculator.sum("1,2\n3"), is(6));
		}
	
	@Test
	public void usesDelimiterSepcified() {
		assertThat(StringCalculator.sum("//;\n1;2"), is(3));
		assertThat(StringCalculator.sum("//.\n2.3.1"), is(6));
		}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void throwsOnNegativeNumber() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3");

		StringCalculator.sum("-3");
		}

	@Test
	public void throwsOnNegativeNumbersWithAllNumbersInExceptionMessage() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3,-5,-13");

		StringCalculator.sum("1,-3,5,-5,-13");
		}
}
