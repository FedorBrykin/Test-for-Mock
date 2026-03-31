package demo.tests;

import demo.app.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.annotation.Mock;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Демонстрация мокирования класса.
 */
@ExtendWith(JokeMockExtension.class)
class MockConcreteClassTest {

    @Mock
    private CalculatorService calculatorService;

    @Test
    void classMock_thenReturn_overridesMethodResult() {
        JokeMock.when(calculatorService.getVersion()).thenReturn("9.9");

        assertEquals("9.9", calculatorService.getVersion());
    }

    @Test
    void classMock_thenThrow_throwsConfiguredException() {
        JokeMock.when(calculatorService.getVersion()).thenThrow(new IllegalStateException("blocked"));

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> calculatorService.getVersion());
        assertEquals("blocked", ex.getMessage());
    }
}

