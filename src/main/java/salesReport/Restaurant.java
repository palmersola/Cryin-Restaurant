package salesReport;

import inventoryManagment.Ingredient;
import inventoryManagment.IngredientList;
import menuManagement.Menu;
import orderProcessing.Order;
import orderProcessing.OrderService;
import tableManagement.Table;
import tableManagement.TableList;
import userLogin.LoginSystem;

public class Restaurant {

    private Menu menu;
    private String name;
    private LoginSystem login;
    private IngredientList ingredients;
    private TableList tables;
    private OrderService orders;

    public Restaurant(String name) {
        this.name = name;
        this.login = new LoginSystem();
        this.ingredients = new IngredientList();
        this.tables = new TableList();
        this.orders = new OrderService();
        this.menu = new Menu("src/main/java/menuManagement/menuItems.txt");
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

    public void addIngredient(Ingredient item) {
        this.ingredients.addIngredient(item);
    }

    public void addTable(Table item) {
        this.tables.addTable(item);
    }

    public void addOrder(Order item) {
        this.orders.addOrder(item);
    }
}
