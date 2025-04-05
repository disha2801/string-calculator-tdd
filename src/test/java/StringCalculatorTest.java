import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void testEmptyStringReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }

    @Test
    public void testSingleNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1,5"));
    }

    @Test
    public void testMultipleNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(10, calc.add("1,2,3,4"));
    }

    @Test
    public void testNewLineDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbersThrowException() {
        StringCalculator calc = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("1,-2,3,-4");
        });
        assertEquals("negative numbers not allowed: -2, -4", exception.getMessage());
    }
}
