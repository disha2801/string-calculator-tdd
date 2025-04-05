import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    public void testEmptyStringReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }
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