package demo.tests;

import demo.app.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.annotation.Mock;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Демонстрация when().thenReturn() для интерфейсов.
 */
@ExtendWith(JokeMockExtension.class)
class MockInterfaceTest {

    @Mock
    private GreetingService mock;

    @Test
    void whenThenReturn_returnsStubbedValue() {
        JokeMock.when(mock.greet("John")).thenReturn("Hi John");
        JokeMock.when(mock.greet("Kate")).thenReturn("Hello Kate");

        assertEquals("Hi John", mock.greet("John"));
        assertEquals("Hello Kate", mock.greet("Kate"));
    }

    @Test
    void whenNoStubbing_returnsNull() {
        String result = mock.greet("Anyone");

        assertEquals(null, result);
    }
}
