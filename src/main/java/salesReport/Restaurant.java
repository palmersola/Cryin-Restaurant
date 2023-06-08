package salesReport;

import inventoryManagment.Ingredient;
import inventoryManagment.IngredientList;
import menuManagement.Menu;
import menuManagement.MenuItem;
import orderProcessing.Order;
import orderProcessing.OrderService;
import tableManagement.Table;
import tableManagement.TableList;
import userLogin.LoginSystem;

import java.util.*;

public class Restaurant {

    private String name;
    private LoginSystem login;
    private IngredientList ingredients;
    private TableList tables;
    private Menu menu;
    private OrderService orders;
    private DailySalesReport report;

    public Restaurant(String name) {
        this.name = name;
        this.login = new LoginSystem();
        this.ingredients = new IngredientList();
        this.tables = new TableList();
        this.menu = new Menu("src/main/java/menuManagement/menuItems.txt");
        this.orders = new OrderService();
        this.report = new DailySalesReport();
    }

    public Menu getMenu() {
        return menu;

    }

    public String getName() {
        return name;
    }

    public LoginSystem getLogin() {
        return login;
    }

    public IngredientList getIngredients() {
        return ingredients;
    }

    public TableList getTables() {
        return tables;
    }

    public OrderService getOrders() {
        return orders;
    }

    public DailySalesReport getReport() {
        return report;
    }

    public void addIngredient(Ingredient item) {
        this.ingredients.addIngredient(item);
    }

    public void addTable(Table item) {
        this.tables.addTable(item);
    }

    public void addOrder(int id, Map<String, Integer> items, int tableId) {
        HashMap<MenuItem, Integer> foods = new HashMap<>();
        double[] total = {0};  // Use an array to hold the mutable value

        items.forEach((k, v) -> {
            MenuItem food = this.menu.getItem(k);
            foods.put(food, v);
            total[0] += food.getPrice()*v;  // Access the mutable value from the array
            food.setTimesOrdered(v);
        });

        this.report.setTotalRevenue(total[0]);
        this.orders.addOrder(new Order(id, foods, total[0], tableId));
        this.tables.getTable(tableId).setTableRevenue(total[0]);
    }
}
