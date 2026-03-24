package demo.app;

public class DemoApplication {

    public static void main(String[] args) {
        NotificationGateway notificationGateway = new NotificationGateway() {
            @Override
            public Boolean sendWelcomeEmail(String email, String text) {
                System.out.println("Sending to " + email + ": " + text);
                return true;
            }
        };
        AuditGateway auditGateway = (action, payload) -> {
            System.out.println("Audit: " + action + " -> " + payload);
            return true;
        };

        UserRegistrationService service = new UserRegistrationService(notificationGateway, auditGateway);
        String result = service.register("  Demo@Example.COM  ");
        System.out.println("Result: " + result);
    }
}
