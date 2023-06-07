import inventoryManagment.Ingredient;
import inventoryManagment.InventoryMain;
import menuManagement.MenuMain;
import orderProcessing.Order;
import orderProcessing.OrderMain;
import salesReport.ReportMain;
import salesReport.Restaurant;
import tableManagement.Table;
import tableManagement.TableMain;
import userLogin.UserMain;

import java.util.Map;
import java.util.Scanner;

//test
public class Main {
    public static void main(String[] args) {

        boolean loop = true;
        Restaurant rize = new Restaurant("Rize N' Cryin");

        rize.addIngredient(new Ingredient("Rice", 45));
        rize.addIngredient(new Ingredient("Beans", 576));
        rize.addIngredient(new Ingredient("Cheese", 4));
        rize.addIngredient(new Ingredient("Beef", 10));

        rize.addTable( new Table( 1,2));
        rize.addTable( new Table( 2,4));
        rize.addTable( new Table( 3,6));
        rize.addTable( new Table( 4,8));
        rize.addTable( new Table( 5,50));

        rize.addOrder(new Order(1, Map.of("Chicken Nuggies", 2, "Fires", 1), 150.0));
        rize.addOrder(new Order(2, Map.of("Milkshake", 3), 75.0));

        while(loop){

            Scanner scanner = new Scanner(System.in);

            boolean manager = UserMain.runLogin(rize.getLogin());
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
                case 4 -> OrderMain.runOrder(rize.getOrders());
                case 5 -> ReportMain.runReport(rize);
                case 6 -> loop = false;
                default -> System.out.println("Invalid choice. Please try again.");

            }
        }

    }
}
