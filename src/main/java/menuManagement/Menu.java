package menuManagement;

import inventoryManagment.Ingredient;
import inventoryManagment.IngredientList;
import salesReport.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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
                             double newPrice, List<Ingredient> newIngredients) {
        menuItem.setName(newName);
        menuItem.setDescription(newDescription);
        menuItem.setPreparationTime(newPreparationTime);
        menuItem.setPrice(newPrice);
        menuItem.setIngredients(newIngredients);
        saveMenuItemsToFile();
    }
    
    public MenuItem getItem(String item){
        MenuItem found = null;
        for(MenuItem food: menuItems){
            if(Objects.equals(food.getName(), item)) found = food;
        }
        return found;
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
                List<Ingredient> ingredients = menuItem.getIngredients();
                for (Ingredient ingredient : ingredients) {
                    writer.write(ingredient.getName());
                    writer.newLine();
                }
                writer.write("done");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMenuItemsFromFile(Restaurant res) {
        IngredientList ing = res.getIngredients();
        try (BufferedReader reader = new BufferedReader(new FileReader(menuFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line;
                String description = reader.readLine();
                int preparationTime = Integer.parseInt(reader.readLine());
                double price = Double.parseDouble(reader.readLine());

                List<Ingredient> ingredients = new ArrayList<>();
                while (!(line = reader.readLine()).equalsIgnoreCase("done")) {
                    ingredients.add(ing.getIngredient(line));
                }

                MenuItem menuItem = new MenuItem(name, description, preparationTime, price, ingredients);
                menuItems.add(menuItem);
            }
        } catch (IOException e) {
            System.out.println("Error loading menu items from file: " + e.getMessage());
            System.exit(-1);
        }
    }

    public String displayPopular(){
        List<MenuItem> items = menuItems;
        items.sort(Comparator.comparing(MenuItem::getTimesOrdered).reversed());

        StringBuilder all = new StringBuilder();
        items.forEach(item -> all.append(item.getTimesOrdered()));
        return "Most Popular Items:\n" + all;
    }
}
