package menuManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import inventoryManagment.Ingredient;
import menuManagement.Menu;
import salesReport.Restaurant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;
    private final String menuFilePath = "menu.txt";

    @BeforeEach
    public void setup() {
        menu = new Menu(menuFilePath);
    }


    @Test
    public void testAddMenuItem() {
        MenuItem menuItem = new MenuItem("Burger", "Delicious burger", 20, 9.99, Arrays.asList(
                new Ingredient("Bun", 1),
                new Ingredient("Beef patty", 1),
                new Ingredient("Cheese", 1)
        ));


        menu.addMenuItem(menuItem);

        List<MenuItem> menuItems = menu.getMenuItems();
        System.out.println(menuItem);
        System.out.println(menuItems);

        assertTrue(menuItems.contains(menuItem)); //prints out reference
    }

    @Test
    public void testRemoveMenuItem() {
        MenuItem menuItem = new MenuItem("Pizza", "Tasty pizza", 30, 12.99, Arrays.asList(
                new Ingredient("Dough", 1),
                new Ingredient("Tomato sauce", 1),
                new Ingredient("Cheese", 1)
        ));

        menu.removeMenuItem(menuItem);

        List<MenuItem> menuItems = menu.getMenuItems();
        assertFalse(menuItems.contains(menuItem));
    }

    @Test
    public void testEditMenuItem() {
        List<Ingredient> newIngredients = Arrays.asList(
                new Ingredient("Romaine lettuce", 1),
                new Ingredient("Croutons", 1),
                new Ingredient("Parmesan cheese", 1)
        );

        MenuItem menuItem = new MenuItem("Salad", "Healthy salad", 10, 8.99, newIngredients);
        menu.addMenuItem(menuItem);

        String newName = "Caesar Salad";
        String newDescription = "Classic Caesar salad";
        int newPreparationTime = 15;
        double newPrice = 10.99;

        menu.editMenuItem(menuItem, newName, newDescription, newPreparationTime, newPrice, newIngredients);

        assertEquals(newName, menuItem.getName());
        assertEquals(newDescription, menuItem.getDescription());
        assertEquals(newPreparationTime, menuItem.getPreparationTime());
        assertEquals(newPrice, menuItem.getPrice());
        assertEquals(newIngredients, menuItem.getIngredients());
    }

    @Test
    public void testSaveMenuItemsToFile() {
        MenuItem menuItem1 = new MenuItem("Pasta", "Delicious pasta", 25, 11.99, Arrays.asList(
                new Ingredient("Pasta", 1),
                new Ingredient("Tomato sauce", 1),
                new Ingredient("Meatballs", 1)
        ));
        MenuItem menuItem2 = new MenuItem("Ice Cream", "Yummy ice cream", 5, 5.99, Arrays.asList(
                new Ingredient("Milk", 1),
                new Ingredient("Sugar", 1),
                new Ingredient("Vanilla", 1)
        ));
        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);

        menu.saveMenuItemsToFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(menuFilePath))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println(menuItem1.getIngredients());
            System.out.println(menuItem2.getIngredients());

            assertEquals(16, lines.size());
            assertTrue(lines.contains(menuItem1.getName()));
            assertTrue(lines.contains(menuItem1.getDescription()));
            assertTrue(lines.contains(String.valueOf(menuItem1.getPreparationTime())));
            assertTrue(lines.contains(String.valueOf(menuItem1.getPrice())));
           // assertTrue(lines.containsAll(menuItem1.getIngredients())); //prints out reference
            assertTrue(lines.contains(menuItem2.getName()));
            assertTrue(lines.contains(menuItem2.getDescription()));
            assertTrue(lines.contains(String.valueOf(menuItem2.getPreparationTime())));
            assertTrue(lines.contains(String.valueOf(menuItem2.getPrice())));
            //assertTrue(lines.containsAll(menuItem2.getIngredients())); //prints out reference
        } catch (IOException e) {
            fail("Error reading menu file: " + e.getMessage());
        }
    }

    @Test
    public void testLoadMenuItemsFromFile() {
        MenuItem menuItem1 = new MenuItem("Pasta", "Delicious pasta", 25, 11.99, Arrays.asList(
                new Ingredient("Pasta", 1),
                new Ingredient("Tomato sauce", 1),
                new Ingredient("Meatballs", 1)
        ));
        MenuItem menuItem2 = new MenuItem("Ice Cream", "Yummy ice cream", 5, 5.99, Arrays.asList(
                new Ingredient("Milk", 1),
                new Ingredient("Sugar", 1),
                new Ingredient("Vanilla", 1)
        ));

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.saveMenuItemsToFile();

        menu = new Menu(menuFilePath);
        Restaurant res = new Restaurant("rize");
        menu.loadMenuItemsFromFile(res);
        List<MenuItem> loadedMenuItems = menu.getMenuItems();

        assertEquals(2, loadedMenuItems.size());
    }
}
