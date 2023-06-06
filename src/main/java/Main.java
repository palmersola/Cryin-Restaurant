import inventoryManagment.Ingredient;
import inventoryManagment.IngredientList;
import inventoryManagment.InventoryMain;
import menuManagement.MenuMain;
import tableManagement.Table;
import tableManagement.TableList;
import tableManagement.TableMain;
import userLogin.LoginSystem;
import userLogin.UserMain;

import java.util.Scanner;

//test
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        LoginSystem loginSystem = new LoginSystem();
        IngredientList ingredientList = new IngredientList();
        TableList tableList = new TableList();

        ingredientList.addIngredient(new Ingredient("Rice", 45));
        ingredientList.addIngredient(new Ingredient("Beans", 576));
        ingredientList.addIngredient(new Ingredient("Cheese", 4));
        ingredientList.addIngredient(new Ingredient("Beef", 10));

        tableList.addTable( new Table( 1,2));
        tableList.addTable( new Table( 2,4));
        tableList.addTable( new Table( 3,6));
        tableList.addTable( new Table( 4,8));
        tableList.addTable( new Table( 5,50));

        while(loop){
            boolean manager = UserMain.runLogin(loginSystem);
            System.out.println("""
                    Welcome to your restaurant. What would you like to use?
                       1.) Inventory
                       2.) Tables
                       3.) Menu
                       4.) Quit
                    """);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 -> InventoryMain.runManager(ingredientList);
                case 2 -> TableMain.runTable(tableList);
                case 3 -> MenuMain.runMenu();
                case 4 -> loop = false;
            }
        }

    }
}
