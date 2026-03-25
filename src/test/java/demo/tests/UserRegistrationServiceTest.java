package demo.tests;

import demo.app.AuditGateway;
import demo.app.NotificationGateway;
import demo.app.UserRegistrationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.nsu.annotation.Mock;
import ru.nsu.api.JokeMock;
import ru.nsu.extension.JokeMockExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Интеграционный тест: UserRegistrationService с замоканными зависимостями.
 */
@ExtendWith(JokeMockExtension.class)
class UserRegistrationServiceTest {

    @Mock
    private NotificationGateway gateway;

    @Mock
    private AuditGateway auditGateway;

    @Test
    void register_succeedsWhenDependenciesReturnTrue() {
        JokeMock.when(gateway.sendWelcomeEmail("john@example.com", "Welcome!"))
                .thenReturn(Boolean.TRUE);
        JokeMock.when(auditGateway.writeEntry("REGISTER", "john@example.com"))
                .thenReturn(Boolean.TRUE);

        UserRegistrationService service = new UserRegistrationService(gateway, auditGateway);
        String result = service.register("John@Example.com");

        assertEquals("OK:john@example.com", result);
    }

    @Test
    void register_throwsWhenGatewayThrows() {
        JokeMock.when(gateway.sendWelcomeEmail("anna@example.com", "Welcome!"))
                .thenThrow(new IllegalStateException("smtp unavailable"));

        UserRegistrationService service = new UserRegistrationService(gateway, auditGateway);

        assertThrows(IllegalStateException.class, () -> service.register("anna@example.com"));
    }
}
