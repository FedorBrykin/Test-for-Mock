package demo.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.annotation.Spy;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Демонстрация spy(), doReturn().when() и doThrow().when().
 */
@ExtendWith(JokeMockExtension.class)
class SpyDoReturnDoThrowTest {

    @Spy
    private List<String> spy = new ArrayList<>();

    @Test
    void spy_delegatesToRealObjectWhenNoStubbing() {
        spy.clear();
        spy.add("a");
        spy.add("b");

        assertEquals(2, spy.size());
        assertEquals("a", spy.get(0));
    }

    @Test
    void doReturn_when_overridesSpyMethod() {
        spy.clear();
        spy.add("x");
        JokeMock.doReturn(100).when(spy).size();

        assertEquals(100, spy.size());
        assertEquals("x", spy.get(0)); // не замокано — идёт в реальный объект
    }

    @Test
    void doThrow_when_spyThrowsException() {
        spy.clear();
        JokeMock.doThrow(new IllegalStateException("disabled")).when(spy).size();

        assertThrows(IllegalStateException.class, spy::size);
    }

    @Test
    void spyOnList_doReturnOverridesSize() {
        spy.clear();
        spy.add("a");
        spy.add("b");
        JokeMock.doReturn(100).when(spy).size();

        assertEquals(100, spy.size());
        assertEquals("a", spy.get(0));
    }
}
