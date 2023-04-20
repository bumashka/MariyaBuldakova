package homework1;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

public class Initializer {
    protected static Calculator calculator;

    @BeforeAll
    static void initialize() {
        calculator = new Calculator();
    }
}
