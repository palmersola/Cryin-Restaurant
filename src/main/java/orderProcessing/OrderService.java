package orderProcessing;
import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private Map<Integer, Order> orders;

    public OrderService() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void updateOrderStatus(int orderId, OrderStatus status) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(status);
            System.out.println("Order " + orderId + " updated to status: " + status);
        } else {
            System.out.println("Order not found.");
        }
    }

    public void displayOrderStatus(int orderId) {

//        Order order = orders.get(orderId);
//        if (order != null) {
//            System.out.println(order);
//        } else {
//            System.out.println("Order not found.");
//        }
    }


    public String displayAll() {
        StringBuilder all = new StringBuilder();
        this.orders.forEach((id, order) -> all.append(order.toString()));
        return "\nDetailed Orders:" + all;
    }
}