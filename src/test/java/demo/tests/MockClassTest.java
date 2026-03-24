package demo.tests;

import demo.app.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Демонстрация мокирования: when().thenReturn() для разных сценариев.
 */
@ExtendWith(JokeMockExtension.class)
class MockClassTest {

    @Test
    void mock_multipleStubbings() {
        GreetingService mock = JokeMock.mock(GreetingService.class);

        JokeMock.when(mock.greet("Alice")).thenReturn("Hi Alice");
        JokeMock.when(mock.greet("Bob")).thenReturn("Hello Bob");

        assertEquals("Hi Alice", mock.greet("Alice"));
        assertEquals("Hello Bob", mock.greet("Bob"));
    }

    @Test
    void mock_whenNoStubbing_returnsNull() {
        GreetingService mock = JokeMock.mock(GreetingService.class);

        assertNull(mock.greet("Anyone"));
    }
}
