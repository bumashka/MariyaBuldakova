package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SubTest extends BeforeAllTests{
    @ParameterizedTest
    @CsvSource({"0, 0", "0, 91", "-78, 1123", "123, -897", "1254, 1254", "1237.21334, 1234645.231", "-123.231, -123.3221"})
    public void testSub(double first, double second){
        Assertions.assertEquals(first - second, calculator.sub(first, second), 0.00001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Double.MAX_VALUE, Double.MIN_VALUE})
    public void testSubOnBoundaries(double first){
        Assertions.assertEquals(0, calculator.sub(first, first), 0.00001);
    }
}
