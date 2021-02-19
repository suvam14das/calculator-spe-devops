import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class CalculatorTest {

    private static final double DELTA = 1e-15;

    @Test
    public void squarerootEquals() {
        assertEquals("Square root for True Positive", 1.4142135623730951, Calculator.squareroot(2), DELTA);
        assertEquals("Square root for True Positive", Double.NaN, Calculator.squareroot(-2), DELTA);
    }

    @Test
    public void squarerootNotEquals() {
        assertNotEquals("Square root for False Positive", -6, Calculator.squareroot(-36), DELTA);
        assertNotEquals("Square root for False Positive", Double.NaN, Calculator.squareroot(36), DELTA);
    }

    @Test
    public void factorialEquals() {
        assertEquals("Factorial for True Positive", 120, Calculator.factorial(5), DELTA);
        assertEquals("Factorial for True Positive", Double.NaN, Calculator.factorial(-5), DELTA);
    }

    @Test
    public void factorialNotEquals() {
        assertNotEquals("Factorial for True Positive", 120, Calculator.factorial(-10), DELTA);
        assertNotEquals("Factorial for True Positive", Double.NaN, Calculator.factorial(10), DELTA);
    }

    @Test
    public void naturallogEquals() {
        assertEquals("Natural log for True Positive", 2.302585092994046, Calculator.naturallog(10), DELTA);
        assertEquals("Natural log for True Positive", Double.NaN, Calculator.naturallog(0), DELTA);
    }

    @Test
    public void naturallogNotEquals() {
        assertNotEquals("Natural log for False Positive", 6, Calculator.naturallog(45), DELTA);
        assertNotEquals("Natural log for False Positive", 0, Calculator.naturallog(-5), DELTA);
    }

}
