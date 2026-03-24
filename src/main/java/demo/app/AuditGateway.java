package demo.app;

public interface AuditGateway {
    Boolean writeEntry(String action, String payload);
}
