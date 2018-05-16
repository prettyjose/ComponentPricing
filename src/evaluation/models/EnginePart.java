package evaluation.models;

public class EnginePart implements Part {

    private final int PART_NUM;
    private Double price;

    public EnginePart(int partId, Double price) {
        PART_NUM = partId;
        this.price = price;
    }

    @Override
    public void setPrice(Double newPrice) {
        price = newPrice;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
