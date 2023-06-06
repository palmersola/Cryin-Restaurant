package menuManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;
    private String menuFilePath;

    public Menu(String menuFilePath) {
        menuItems = new ArrayList<>();
        this.menuFilePath = menuFilePath;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
        saveMenuItemsToFile();
    }

    public void removeMenuItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
        saveMenuItemsToFile();
    }

    public void editMenuItem(MenuItem menuItem, String newName, String newDescription, int newPreparationTime,
                             double newPrice, List<String> newIngredients) {
        menuItem.setName(newName);
        menuItem.setDescription(newDescription);
        menuItem.setPreparationTime(newPreparationTime);
        menuItem.setPrice(newPrice);
        menuItem.setIngredients(newIngredients);
        saveMenuItemsToFile();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void saveMenuItemsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(menuFilePath))) {
            for (MenuItem menuItem : menuItems) {
                writer.write(menuItem.getName());
                writer.newLine();
                writer.write(menuItem.getDescription());
                writer.newLine();
                writer.write(String.valueOf(menuItem.getPreparationTime()));
                writer.newLine();
                writer.write(String.valueOf(menuItem.getPrice()));
                writer.newLine();
                List<String> ingredients = menuItem.getIngredients();
                for (String ingredient : ingredients) {
                    writer.write(ingredient);
                    writer.newLine();
                }
                writer.write("done");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMenuItemsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(menuFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line;
                String description = reader.readLine();
                int preparationTime = Integer.parseInt(reader.readLine());
                double price = Double.parseDouble(reader.readLine());

                List<String> ingredients = new ArrayList<>();
                while (!(line = reader.readLine()).equalsIgnoreCase("done")) {
                    ingredients.add(line);
                }

                MenuItem menuItem = new MenuItem(name, description, preparationTime, price, ingredients);
                menuItems.add(menuItem);
            }
        } catch (IOException e) {
            System.out.println("Error loading menu items from file: " + e.getMessage());
            System.exit(-1);
        }
    }
}
