package evaluation.pricing;

import evaluation.resources.EnginePartResource;
import evaluation.auditing.AuditingComponent;

import java.util.HashMap;
import java.util.Map;

public class EnginePartPricingComponent implements PricingComponent{
//    Map<Integer, Double> partPrices = new ConcurrentHashMap<Integer, Double>();

    private Map<Integer, EnginePartResource> partPrices = new HashMap<Integer, EnginePartResource>();
    private AuditingComponent auditor;

    public final static int MAX_CAPACITY = 250000;

    @Override
    public void setPartPrice(int partId, Double price) {

        if(partPrices.size() == MAX_CAPACITY) {
            throw new RuntimeException("Sorry. Can't process. Limit is reached.");
        }

        if(partPrices.containsKey(partId)){
            partPrices.get(partId).setPrice(price);
        }else{
            partPrices.put(partId, new EnginePartResource(partId, price));
        }

        if(auditor != null) {
            auditor.recordPartPriceUpdate(partId, price);
        }
    }

    @Override
    public Double getPartPrice(int partId) {
        return partPrices.containsKey(partId)? partPrices.get(partId).getPrice() : null;
    }

    @Override
    public void setAuditingComponent(AuditingComponent auditor) {
        this.auditor = auditor;
    }
}
