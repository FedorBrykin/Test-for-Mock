package demo.app;

public class UserRegistrationService {
    private final NotificationGateway notificationGateway;
    private final AuditGateway auditGateway;

    public UserRegistrationService(NotificationGateway notificationGateway, AuditGateway auditGateway) {
        this.notificationGateway = notificationGateway;
        this.auditGateway = auditGateway;
    }

    public String register(String email) {
        String normalized = email.trim().toLowerCase();
        Boolean sent = notificationGateway.sendWelcomeEmail(normalized, "Welcome!");
        if (!Boolean.TRUE.equals(sent)) {
            throw new IllegalStateException("Failed to send welcome email");
        }

        Boolean logged = auditGateway.writeEntry("REGISTER", normalized);
        if (!Boolean.TRUE.equals(logged)) {
            throw new IllegalStateException("Failed to write audit log");
        }

        return "OK:" + normalized;
    }
}
