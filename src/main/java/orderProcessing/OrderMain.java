package orderProcessing;


import orderProcessing.Order;
import orderProcessing.OrderService;
import orderProcessing.OrderStatus;
import salesReport.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class OrderMain {
    public static void runOrder(Restaurant res) {
        res.getMenu().displayPopular();
        res.getOrders().displayAll();

    }
}