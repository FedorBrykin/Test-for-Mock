package demo.tests;

import demo.app.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.annotation.Mock;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Демонстрация аннотации @Mock с JokeMockExtension.
 */
@ExtendWith(JokeMockExtension.class)
class AnnotationMockTest {

    @Mock
    private GreetingService greetingService;

    @Test
    void mockAnnotatedField_isInitializedByExtension() {
        JokeMock.when(greetingService.greet("Alice")).thenReturn("Hi Alice");

        assertEquals("Hi Alice", greetingService.greet("Alice"));
    }
}
