package demo.tests;

import demo.app.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.annotation.Mock;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Демонстрация мокирования: when().thenReturn().
 */
@ExtendWith(JokeMockExtension.class)
class MockClassTest {

    @Mock
    private GreetingService mock;

    @Test
    void mock_multipleStubbings() {
        JokeMock.when(mock.greet("Alice")).thenReturn("Hi Alice");
        JokeMock.when(mock.greet("Bob")).thenReturn("Hello Bob");

        assertEquals("Hi Alice", mock.greet("Alice"));
        assertEquals("Hello Bob", mock.greet("Bob"));
    }

    @Test
    void mock_whenNoStubbing_returnsNull() {
        assertNull(mock.greet("Anyone"));
    }
}
