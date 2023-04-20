package homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IsPositiveTest extends Initializer {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9857483, Integer.MAX_VALUE})
    void testIsPositiveOnPositiveInts(int number) {
        Assertions.assertTrue(calculator.isPositive(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100, Integer.MIN_VALUE})
    void testIsPositiveOnNegativeInts(int number) {
        Assertions.assertFalse(calculator.isPositive(number));
    }
}
