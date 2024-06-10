package testingAssignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testSimpleAddition() {
        Calculator calculator = new Calculator("2 km + 3 km");
        int result = calculator.calculateExpression();
        assertEquals(5, result);
    }

    @Test
    void testSimpleSubtraction() {
        Calculator calculator = new Calculator("5 km - 3 km");
        int result = calculator.calculateExpression();
        assertEquals(2, result);
    }

    @Test
    void testNegativeStart() {
        Calculator calculator = new Calculator("- 2 km + 5 km");
        int result = calculator.calculateExpression();
        assertEquals(3, result);
    }

    @Test
    void testAdditionWithDifferentScales() {
        Calculator calculator = new Calculator("1 km + 1000 m");
        int result = calculator.calculateExpression();
        assertEquals(2000, result);
    }

    @Test
    void testSubtractionWithDifferentScales() {
        Calculator calculator = new Calculator("2 km - 1000 m");
        int result = calculator.calculateExpression();
        assertEquals(1000, result);
    }

    @Test
    void testComplexExpression() {
        Calculator calculator = new Calculator("1 km + 1000 m + 1 km - 500 m");
        int result = calculator.calculateExpression();
        assertEquals(2500, result);
    }



    @Test
    void testInvalidScale() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator calculator = new Calculator("1 km + 2 xyz");
            calculator.calculateExpression();
        });
    }

    @Test
    void testInvalidNumber() {
        assertThrows(NumberFormatException.class, () -> {
            Calculator calculator = new Calculator("1 km + abc m");
            calculator.calculateExpression();
        });
    }
}