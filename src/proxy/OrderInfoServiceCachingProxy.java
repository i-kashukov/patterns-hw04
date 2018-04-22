package proxy;

import java.util.HashMap;
import java.util.Map;

public class OrderInfoServiceCachingProxy implements OrderInfoService {

    private OrderInfoService orderInfoService;
    private Map<Integer,String> cache;

    public OrderInfoServiceCachingProxy(OrderInfoService orderInfoService) {
        this.orderInfoService = orderInfoService;
        this.cache = new HashMap<>();
    }

    @Override
    public String getOrderById(int id) {
        if(cache.containsKey(id)) {
            System.out.println("Данные о заказе " + id + " получены из кэша.");
            return cache.get(id);
        } else {
            System.out.println("Данные о заказе " + id + " отсутствуют в кэше; выполняем запрос и добавление.");
            String ret = orderInfoService.getOrderById(id);
            cache.put(id,ret);
            return ret;
        }
    }
}
