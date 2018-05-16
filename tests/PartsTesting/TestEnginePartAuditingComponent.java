package PartsTesting;

import evaluation.auditing.EnginePartAuditingComponent;
import org.junit.Test;


public class TestEnginePartAuditingComponent {

    EnginePartAuditingComponent enginePartAuditingComponent =  new EnginePartAuditingComponent();

    @Test
    public void testrecordPartPriceUpdate(){
        final int partNum = 2;
        Double price = 30.0;
        enginePartAuditingComponent.recordPartPriceUpdate(partNum, price);
    }
}
