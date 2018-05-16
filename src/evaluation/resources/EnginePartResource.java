package evaluation.resources;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import evaluation.models.EnginePart;

public class EnginePartResource {
    ReadWriteLock lock = new ReentrantReadWriteLock();

    EnginePart part;

    public EnginePartResource(int partId, Double price) {
        part = new EnginePart(partId, price);
    }

    public void setPrice(Double newPrice) {
        try{
            lock.writeLock().lockInterruptibly();
            part.setPrice(newPrice);
        }catch(InterruptedException ie) {
            System.out.println("price setting was interrupted");
        }finally{
            lock.writeLock().unlock();
        }
    }

    public Double getPrice() {
        Double currentPrice = 0.0;
        try{
            lock.readLock().lockInterruptibly();
            currentPrice = part.getPrice();
        }catch(InterruptedException ie) {
            System.out.println("price getting was interrupted");
        }finally{
            lock.readLock().unlock();
        }
        return currentPrice;
    }
}
