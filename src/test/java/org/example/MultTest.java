package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MultTest extends BeforeAllTests{
    @ParameterizedTest
    @CsvSource({"112, 245", "-121, 22", "-198, -120", "198, -10", "0, 0", "-19, 0", "23.2, 12.5", "908.1, 9871.2", "2022.2022, 657.12342"})
    public void testMultOnDifNumbers(double first, double second){
        Assertions.assertEquals(first*second, calculator.mult(first, second), 0.00001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Double.MAX_VALUE, Double.MIN_VALUE})
    public void testMultOnBoundaries(double first){
        Assertions.assertEquals(first*first, calculator.mult(first, first), 0.00001);
    }
}
