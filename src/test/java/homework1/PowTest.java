package homework1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PowTest extends Initializer {
    @ParameterizedTest
    @CsvSource({"1, 2", "-1, 2", "196, 189", "-198, 0", "198, -10", "12.2, 2", "34, 2.3"})
    void testPowOnDifPowers(double base, double power) {
        Assertions.assertEquals(Math.pow(base, power), calculator.pow(base, power), 0.00001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Double.MAX_VALUE, Double.MIN_VALUE})
    void testPowOnBoundaries(double base) {
        Assertions.assertEquals(Math.pow(base, base), calculator.pow(base, base), 0.00001);
    }
}
