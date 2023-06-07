package orderProcessing;


import orderProcessing.Order;
import orderProcessing.OrderService;
import orderProcessing.OrderStatus;

import java.util.HashMap;
import java.util.Map;

public class OrderMain {
    public static void runOrder(OrderService orderList) {
        OrderService system = new OrderService();

        // Creating orders
        Order order1 = new Order(1, Map.of("Chicken Nuggies", 2, "Fires", 1), 150.0);
        Order order2 = new Order(2, Map.of("Milkshake", 3), 75.0);

        // Adding orders to the system
        system.addOrder(order1);
        system.addOrder(order2);

        // Updating order status
        system.updateOrderStatus(1, OrderStatus.PREPARING);
        system.updateOrderStatus(2, OrderStatus.READY);

        // Displaying order status
        system.displayOrderStatus(1);
        system.displayOrderStatus(2);
        system.displayOrderStatus(3);
    }
}