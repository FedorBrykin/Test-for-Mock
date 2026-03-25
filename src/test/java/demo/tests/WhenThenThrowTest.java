package demo.tests;

import demo.app.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.annotation.Mock;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Демонстрация when().thenThrow().
 */
@ExtendWith(JokeMockExtension.class)
class WhenThenThrowTest {

    @Mock
    private GreetingService mock;

    @Test
    void whenThenThrow_throwsConfiguredException() {
        JokeMock.when(mock.greet("error")).thenThrow(new IllegalArgumentException("Invalid name"));

        assertThrows(IllegalArgumentException.class, () -> mock.greet("error"));
    }

    @Test
    void whenThenThrow_runtimeException() {
        JokeMock.when(mock.greet("boom")).thenThrow(new IllegalStateException("Service unavailable"));

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> mock.greet("boom"));
        org.junit.jupiter.api.Assertions.assertEquals("Service unavailable", ex.getMessage());
    }
}
