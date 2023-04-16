package org.example;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

public class BeforeAllTests {
    protected static Calculator calculator;

    @BeforeAll
    public static void initialize(){
        calculator = new Calculator();
    }
}
