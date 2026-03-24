package demo.app;

public interface NotificationGateway {
    Boolean sendWelcomeEmail(String email, String text);
}
