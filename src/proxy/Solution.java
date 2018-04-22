package proxy;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        OrderInfoService noCacheInfoService = new OrderInfoServiceImpl();
        OrderInfoService cachingInfoService = new OrderInfoServiceCachingProxy(noCacheInfoService);
        Random random = new Random();

        System.out.println("== Тест службы без кэширования ==");
        Long start = System.currentTimeMillis();
        for(int i = 0; i != 10; i++) {
            System.out.println(noCacheInfoService.getOrderById(random.nextInt(5)));
        }
        System.out.println("== Общее время работы: " + (System.currentTimeMillis() - start) + " мс. ==\n");


        System.out.println("== Тест службы с кэшированием ==");
        start = System.currentTimeMillis();
        for(int i = 0; i != 10; i++) {
            System.out.println(cachingInfoService.getOrderById(random.nextInt(5)));
        }
        System.out.println("== Общее время работы: " + (System.currentTimeMillis() - start) + " мс. ==");
    }

}
