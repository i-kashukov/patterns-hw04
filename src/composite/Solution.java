package composite;

public class Solution {

    public static void main(String[] args) {
        // заказ может включать в свой состав другие заказы и/или продукты
        Order order1 = new Order(1);
        order1.addEntry(new Product("Продукт 1", 500));
        order1.addEntry(new Product("Продукт 2", 1500));
        order1.addEntry(new Product("Продукт 3", 720));
        order1.addEntry(new Order(2,
                new Product("Продукт 4", 280),
                new Product("Продукт 5", 600)));

        System.out.println("Общая стоимость заказа '" + order1.getDescription() + "': " + order1.getPrice());

    }
}
