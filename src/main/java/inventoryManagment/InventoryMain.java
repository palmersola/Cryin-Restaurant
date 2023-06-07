package inventoryManagment;

import java.util.Scanner;

public class InventoryMain {
    public static void runManager(IngredientList list) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("""
                    Inventory Management
                       1.) See all ingredients
                       2.) Add new ingredients
                       3.) Check low ingredients
                       4.) Check individual ingredient
                       5.) Add Stock
                       6.) Back
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> list.printAll();
                case 2 -> {
                    System.out.println("Enter ingredient name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter quantity:");
                    int amount = Integer.parseInt(scanner.nextLine());
                    list.addIngredient(new Ingredient(name, amount));
                }
                case 3 -> list.lowStock();
                case 4 -> {
                    System.out.println("Input ingredient name");
                    list.printQuantity(scanner.nextLine());
                }
//                case 5 -> {
//                    System.out.println("Input ingredient name");
//                    String name = scanner.nextLine();
//                    System.out.println("How much stock are you adding?");
//                    int amount = Integer.parseInt(scanner.nextLine());
//                    list.addStock(name, amount);
//                }
                case 6 -> loop = false;
            }
        }

    }
}
