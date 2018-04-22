package composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order implements Billable {
    private List<Billable> entries = new ArrayList<>();
    private int number;

    public Order(int number, Billable... entries) {
        this.number = number;
        this.entries.addAll(Arrays.asList(entries));
    }

    public void addEntry(Billable entry) {
        this.entries.add(entry);
    }

    @Override
    public String getDescription() {
        return "Заказ №" + number;
    }

    @Override
    public int getPrice() {
        return entries.stream()
                .mapToInt(Billable::getPrice)
                .sum();
    }
}
