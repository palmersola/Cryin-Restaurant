package orderProcessing;

import menuManagement.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderId;
    private HashMap<MenuItem, Integer> items;
    private double totalPrice;
    private OrderStatus status;
    private int tableId;

    public Order(int orderId, HashMap<MenuItem, Integer> items, double totalPrice, int tableId) {
        this.orderId = orderId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = OrderStatus.INQUEUE;
        this.tableId = tableId;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<MenuItem, Integer> getItems() {
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

    public String timesOrdered(){
        StringBuilder orderTotal = new StringBuilder();
        for (Map.Entry<MenuItem, Integer> item : items.entrySet())
            orderTotal.append("  ").append(item.getKey().getName()).append(": ").append(item.getKey().getTimesOrdered());
        return  "   " + orderTotal  ;
    }

    @Override
    public String toString() {
        StringBuilder itemList = new StringBuilder();
        for (Map.Entry<MenuItem, Integer> item : items.entrySet())
            itemList.append("  ").append(item.getKey().getName())
                    .append(": ").append(item.getValue()).append("\n");
        return "\nOrder ID: " + orderId + "\nTable " + tableId  + "\nItems: \n" + itemList  +
                "Total Price: $" + totalPrice + "\nStatus: " + status + "\n";
    }
}
