import inventoryManagment.Ingredient;
import inventoryManagment.InventoryMain;
import menuManagement.MenuMain;
import orderProcessing.OrderMain;
import salesReport.DailySalesReport;
import salesReport.Restaurant;
import tableManagement.Table;
import tableManagement.TableMain;
import userLogin.UserMain;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        Restaurant rize = new Restaurant("Rize N' Cryin");

        // Add ingredients
        rize.addIngredient(new Ingredient("Bun", 100));
        rize.addIngredient(new Ingredient("Beef Patty", 50));
        rize.addIngredient(new Ingredient("Lettuce", 50));
        rize.addIngredient(new Ingredient("Tomato", 20));
        rize.addIngredient(new Ingredient("Cheese", 50));
        rize.addIngredient(new Ingredient("Pickles", 10));
        rize.addIngredient(new Ingredient("Dough", 12));
        rize.addIngredient(new Ingredient("Tomato Sauce", 100));
        rize.addIngredient(new Ingredient("Mozzarella Cheese", 100));
        rize.addIngredient(new Ingredient("Tortilla", 20));
        rize.addIngredient(new Ingredient("Chicken", 10));
        rize.addIngredient(new Ingredient("Salsa", 30));

        rize.addTable( new Table( 1,2));
        rize.addTable( new Table( 2,4));
        rize.addTable( new Table( 3,6));
        rize.addTable( new Table( 4,8));
        rize.addTable( new Table( 5,10));

        rize.getMenu().loadMenuItemsFromFile(rize);

        rize.addOrder(1, Map.of("Pizza", 2, "Burger", 1), 2);
        rize.addOrder(2, Map.of("Pizza", 3), 3);
        rize.addOrder(3, Map.of("Burger", 3), 2);
        rize.addOrder(4, Map.of("Pizza", 4), 5);

        boolean manager = UserMain.runLogin(rize.getLogin());
        while(loop){
            Scanner scanner = new Scanner(System.in);

            System.out.println("""
                    Welcome to your restaurant. What would you like to use?
                       1.) Inventory
                       2.) Tables
                       3.) Menu
                       4.) Orders
                       5.) Create Report
                       6.) Quit
                    """);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 -> InventoryMain.runManager(rize.getIngredients());
                case 2 -> TableMain.runTable(rize.getTables());
                case 3 -> MenuMain.runMenu(rize);
                case 4 -> OrderMain.runOrder(rize);
                case 5 -> {
                    if (manager) DailySalesReport.runReport(rize);
                    else System.out.println("You do not have manager privleges");
                }
                case 6 -> loop = false;
                default -> System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}
