package evaluation.auditing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EnginePartAuditingComponent implements AuditingComponent{
    ExecutorService auditingService;

    public EnginePartAuditingComponent() {
        auditingService = Executors.newFixedThreadPool(16);
    }
    @Override
    public void recordPartPriceUpdate(int partId, Double partPrice) {
        // using auditing service to have a separate queue for auditing so that the calling thread doesn't have to wait.
        auditingService.execute(() -> {
            /*auditing logic will come here*/
        });
    }
}
