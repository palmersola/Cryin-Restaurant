package orderProcessing;

import java.util.Map;

public class Order {
    private int orderId;
    private Map<String, Integer> items;
    private double totalPrice;
    private OrderStatus status;

    public Order(int orderId, Map<String, Integer> items, double totalPrice) {
        this.orderId = orderId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = OrderStatus.INQUEUE;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                "\nItems: " + items +
                "\nTotal Price: $" + totalPrice +
                "\nStatus: " + status;
    }
}
