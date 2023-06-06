package menuManagement;
import inventoryManagment.Ingredient;
import inventoryManagment.IngredientList;
import salesReport.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMain {
    private static Menu menu;

    public static void runMenu(Restaurant res) {
        menu = res.getMenu();
        menu.loadMenuItemsFromFile(res); // Load menu items from file at the beginning

        // Main menu loop
        boolean exit = true;
        while (exit) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("""
                    Menu for Restaurant Rize 'N' Crying
                       1.) Add Menu Item
                       2.) Remove Menu Item
                       3.) Edit Menu Item
                       4.) View Menu
                       5.) Exit
                    """);

            int choice;
            if (scanner.hasNextLine()) {
                choice = Integer.parseInt(scanner.nextLine());
            } else {
                // Handle the case when no input is available
                System.out.println("No input found. Please try again.");
                scanner.close();
                continue; // Continue to the next iteration of the loop
            }
            scanner.close();


            switch (choice) {
                case 1 -> addMenuItem(scanner, res);
                case 2 -> removeMenuItem(scanner);
                case 3 -> editMenuItem(scanner, res);
                case 4 -> viewMenu();
                case 5 -> exit = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
            scanner.close();
        }

        menu.saveMenuItemsToFile(); // Save menu items to file before exiting
    }

    private static void addMenuItem(Scanner scanner, Restaurant res) {
        System.out.print("Enter the name of the menu item: ");
        String name = scanner.nextLine();

        System.out.print("Enter the description of the menu item: ");
        String description = scanner.nextLine();

        System.out.print("Enter the preparation time of the menu item (in minutes): ");
        int preparationTime = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the price of the menu item: $");
        double price = scanner.nextDouble();
        scanner.nextLine();

        List<Ingredient> ingredients = new ArrayList<>();
        System.out.println("Enter the ingredients of the menu item (one ingredient per line, enter 'done' to finish):");
        String ingredient;
        while (true) {
            ingredient = scanner.nextLine();
            if (ingredient.equalsIgnoreCase("done")) {
                break;
            }
            Ingredient check = res.getIngredients().getIngredient(ingredient);
            if (check == null) {
                res.getIngredients().addIngredient(new Ingredient(ingredient, 0));
            }
            ingredients.add(res.getIngredients().getIngredient(ingredient));
        }

        MenuItem menuItem = new MenuItem(name, description, preparationTime, price, ingredients);
        menu.addMenuItem(menuItem);
        System.out.println("Menu item added successfully.");
    }

    private static void removeMenuItem(Scanner scanner) {
        System.out.print("Enter the name of the menu item to remove: ");
        String name = scanner.nextLine();

        List<MenuItem> menuItems = menu.getMenuItems();
        MenuItem menuItemToRemove = null;
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) {
                menuItemToRemove = menuItem;
                break;
            }
        }

        if (menuItemToRemove != null) {
            menu.removeMenuItem(menuItemToRemove);
            System.out.println("Menu item removed successfully.");
        } else {
            System.out.println("Menu item not found.");
        }
    }

    private static void editMenuItem(Scanner scanner, Restaurant res) {
        System.out.print("Enter the name of the menu item to edit: ");
        String name = scanner.nextLine();

        List<MenuItem> menuItems = menu.getMenuItems();
        MenuItem menuItemToEdit = null;
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) {
                menuItemToEdit = menuItem;
                break;
            }
        }

        if (menuItemToEdit != null) {
            System.out.print("Enter the new name of the menu item: ");
            String newName = scanner.nextLine();

            System.out.print("Enter the new description of the menu item: ");
            String newDescription = scanner.nextLine();

            System.out.print("Enter the new preparation time of the menu item (in minutes): ");
            int newPreparationTime = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the new price of the menu item: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();

            List<Ingredient> newIngredients = new ArrayList<>();
            System.out.println("Enter the new ingredients of the menu item (one ingredient per line, enter 'done' to finish):");
            String ingredient;
            while (true) {
                ingredient = scanner.nextLine();
                if (ingredient.equalsIgnoreCase("done")) {
                    break;
                }
                newIngredients.add(res.getIngredients().getIngredient(ingredient));
            }

            menu.editMenuItem(menuItemToEdit, newName, newDescription, newPreparationTime, newPrice, newIngredients);
            System.out.println("Menu item edited successfully.");
        } else {
            System.out.println("Menu item not found.");
        }
    }

    private static void viewMenu() {
        List<MenuItem> menuItems = menu.getMenuItems();
        if (menuItems.isEmpty()) {
            System.out.println("No menu items found.");
        } else {
            System.out.println("Menu Items:");
            for (MenuItem menuItem : menuItems) {
                System.out.println("------------------------");
                System.out.println("Name: " + menuItem.getName());
                System.out.println("Description: " + menuItem.getDescription());
                System.out.println("Preparation Time: " + menuItem.getPreparationTime());
                System.out.println("Price: " + menuItem.getPrice());
                System.out.println("Ingredients: ");
                List <Ingredient> list = menuItem.getIngredients();
                for ( Ingredient ingredient: list) {
                    System.out.println(ingredient.getName());
                }
            }
            System.out.println("------------------------");
        }
    }

}

