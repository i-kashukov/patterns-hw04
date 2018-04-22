package proxy;

import java.util.Random;

public class OrderInfoServiceImpl implements OrderInfoService {
    private static Random random = new Random();

    @Override
    public String getOrderById(int id) {
        System.out.println("Запрошена информация по заказу " + id + " из хранилища.");
        // основное хранилище данных работает с задержкой
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "<описание заказа " + id + ">";
    }
}
