package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IsPositiveTest extends BeforeAllTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 9857483, Integer.MAX_VALUE})
    public void testIsPositiveOnPositiveInts(int number){
        Assertions.assertTrue(calculator.isPositive(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100, Integer.MIN_VALUE})
    public void testIsPositiveOnNegativeInts(int number){
        Assertions.assertFalse(calculator.isPositive(number));
    }
}
