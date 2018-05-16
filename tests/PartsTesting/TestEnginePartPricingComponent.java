package PartsTesting;

import static org.junit.Assert.*;

import evaluation.auditing.EnginePartAuditingComponent;
import evaluation.pricing.EnginePartPricingComponent;
import org.junit.Test;


public class TestEnginePartPricingComponent {

    EnginePartPricingComponent enginePartPricingComponent =  new EnginePartPricingComponent();
    public final static int MAX_CAPACITY = EnginePartPricingComponent.MAX_CAPACITY;

    @Test
    public void testSetPartPrice(){
        final int partNum = 2;
        Double price = 30.0;
        enginePartPricingComponent.setPartPrice(partNum, price);
        price = 40.5;
        enginePartPricingComponent.setPartPrice(partNum, price);

        assertEquals(price, enginePartPricingComponent.getPartPrice(partNum));
    }

    @Test
    public void testGetPartPrice(){
        final int partNum =1;
        final Double price = 20.0;
        enginePartPricingComponent.setPartPrice(partNum, price);
        assertEquals(price, enginePartPricingComponent.getPartPrice(partNum));
    }


    @Test
    public void testSetAuditingComponent() {
        enginePartPricingComponent.setAuditingComponent(new EnginePartAuditingComponent());
    }
}
