package demo.app;

/**
 * Конкретный класс (не интерфейс) для демонстрации мокирования классов.
 */
public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public String getVersion() {
        return "1.0";
    }
}
