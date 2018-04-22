package composite;

public class Product implements Billable {
    private String description;
    private int price;

    public Product(String description, int price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
