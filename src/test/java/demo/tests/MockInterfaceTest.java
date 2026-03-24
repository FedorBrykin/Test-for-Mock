package demo.tests;

import demo.app.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Демонстрация when().thenReturn() для интерфейсов.
 */
@ExtendWith(JokeMockExtension.class)
class MockInterfaceTest {

    @Test
    void whenThenReturn_returnsStubbedValue() {
        GreetingService mock = JokeMock.mock(GreetingService.class);

        JokeMock.when(mock.greet("John")).thenReturn("Hi John");
        JokeMock.when(mock.greet("Kate")).thenReturn("Hello Kate");

        assertEquals("Hi John", mock.greet("John"));
        assertEquals("Hello Kate", mock.greet("Kate"));
    }

    @Test
    void whenNoStubbing_returnsNull() {
        GreetingService mock = JokeMock.mock(GreetingService.class);

        String result = mock.greet("Anyone");

        assertEquals(null, result);
    }
}
